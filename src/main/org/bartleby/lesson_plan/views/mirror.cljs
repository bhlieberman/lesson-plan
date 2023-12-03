(ns org.bartleby.lesson-plan.views.mirror
  (:require ["@nytimes/react-prosemirror" :refer [ProseMirror react useNodeViews]]
            ["/org/bartleby/lesson_plan/nodeViews" :refer [reactNodeViews]]
            ["prosemirror-commands" :refer [baseKeymap,
                                            chainCommands,
                                            createParagraphNear,
                                            liftEmptyBlock,
                                            newlineInCode,
                                            splitBlock]]
            ["prosemirror-keymap" :refer [keymap]]
            ["prosemirror-model" :refer [Schema]]
            ["prosemirror-state" :refer [EditorState]]
            ["prosemirror-schema-basic" :refer [schema]]
            ["prosemirror-schema-list" :refer [liftListItem splitListItem]]
            ["react" :refer [useCallback useState]]))

(def -schema
  (Schema. #js {:nodes #js {:doc #js {:content "block+"}
                            :paragraph #js {:group "block" :content "inline*"}
                            :list #js {:group "block" :content "list_item+"}
                            :list_item #js {:content "paragraph+" :to-dom (fn [] #js ["li" 0])}
                            :text #js {:group "inline"}}}))

#_(def config (clj->js
               {:doc (.. -schema
                         -topNodeType
                         (create nil #js [(.. -schema
                                              -nodes
                                              -paragraph
                                              createAndFill)
                                          (.. -schema
                                              -nodes
                                              -list
                                              createAndFill)]))
                :schema -schema
                :plugins [(keymap
                           (merge
                            baseKeymap
                            {:Enter (chainCommands
                                     newlineInCode
                                     createParagraphNear
                                     liftEmptyBlock
                                     (splitListItem (.. -schema -nodes -list_item))
                                     splitBlock)
                             "Shift-Enter" (.-Enter baseKeymap)
                             "Shift-Tab" (liftListItem (.. -schema -nodes -list_item))}))
                          (react)]}))

(def -editor-state #_(EditorState.create config))

(defn prose-editor []
  (let [editor-state -editor-state
        views (useNodeViews reactNodeViews)
        nodeViews (.-nodeViews views)
        render (.-renderNodeViews views)
        [mount set-mount] (useState nil)
        [state set-state] (useState editor-state)
        dispatchTransaction (useCallback (fn [tr] (set-state (fn [old] (.apply old tr))) #js []))]
    [:> ProseMirror {:mount mount
                     :state state
                     :nodeViews nodeViews
                     :dispatchTransaction dispatchTransaction}
     [:div {:ref set-mount}]
     (render)]))