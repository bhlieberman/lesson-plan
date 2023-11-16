(ns org.bartleby.lesson-plan.views.grr
  (:require [goog.string :as gstr]
            [org.bartleby.lesson-plan.views.themes :as themes]
            [org.bartleby.lesson-plan.views.truncate :as trunc]
            [reagent.core :as r]
            [re-com.core :refer [button
                                 hyperlink
                                 title v-box]]
            ["react" :refer (createRef)]))

(defn title-attrs [label] {:label label
                           :level :level2
                           :margin-top "2px"
                           :margin-bottom "2px"})

(defn Splash [{:keys [on-route]}]
  [v-box
   :height "200px"
   :children
   [[v-box 
     :justify :center
     :align :center
     :margin "auto"
     :children
     [[title (title-attrs (gstr/quote "I would prefer not to."))]
      [button {:label "Enter"
               :on-click #(on-route :i-do)
               :style {:color            "white"
                       :background-color "#0072bb"
                       :font-size        "22px"
                       :font-weight      "300"
                       :border           "none"
                       :border-radius    "0px"
                       :padding          "10px 20px"}
               :class "btn btn-default"}]]]]])

(defn IDo [{:keys [on-route]}]
  (let [view-title (str "Themes of " (gstr/quote "Bartleby the Scrivener") " by Herman Melville")
        list-item-1-active? (r/atom true)
        list-item-2-active? (r/atom false)
        list-item-3-active? (r/atom false)
        list-item-1-ref (createRef)
        list-item-2-ref (createRef)
        list-item-3-ref (createRef)
        list-item-classes "list-group-item list-group-item-action"]
    (fn [{:keys [on-route]}]
      [v-box
      :justify :center
      :align :center
      :children
      [[title (merge (title-attrs view-title)
                     {:level :level1
                      :style {:margin-top "20px"
                              :margin-bottom "20px"}})] 
       [:ul.list-group
        [:li {:class (cond-> list-item-classes
                       @list-item-1-active? (str " active")
                       (false? @list-item-1-active?) (gstr/removeAt 38))}
         [hyperlink {:on-click (fn [_] 
                                 (.. list-item-1-ref -current scrollIntoView)
                                 (reset! list-item-2-active? false)
                                 (reset! list-item-3-active? false)
                                 (swap! list-item-1-active? not))
                     :label "Isolation"
                     :style {:color (if @list-item-2-active? "white" "blue")}}]]
        [:li.list-group-item {:class (cond-> list-item-classes
                                       @list-item-2-active? (str " active")
                                       (false? @list-item-2-active?) (gstr/removeAt 38))}
         [hyperlink {:on-click (fn [_] 
                                 (.. list-item-2-ref -current scrollIntoView)
                                 (reset! list-item-1-active? false)
                                 (reset! list-item-3-active? false)
                                 (swap! list-item-2-active? not))
                     :label "Professional and economic coercion"
                     :style {:color (if @list-item-2-active? "white" "blue")}}]]
        [:li.list-group-item 
         {:class (cond-> list-item-classes
                   @list-item-3-active? (str " active")
                   (false? @list-item-3-active?) (gstr/removeAt 38))}
         [hyperlink {:on-click (fn [_] 
                                 (.. list-item-3-ref -current scrollIntoView)
                                 (reset! list-item-1-active? false)
                                 (reset! list-item-2-active? false)
                                 (swap! list-item-3-active? not))
                     :label (str "The " (gstr/quote "production of the self"))
                     :style {:color (if @list-item-3-active? "white" "blue")}}]]]
       [:div.container-md.m-4
        [themes/intro]
        [v-box :height "200px" :children [[:p {:ref list-item-1-ref} ""]]]
        [:br]
        [themes/isolation]
        [v-box :children [[:p {:ref list-item-2-ref} ""]] :height "200px"]
        [:br]
        [themes/coercion]
        [v-box :children [[:p {:ref list-item-3-ref} ""]] :height "200px"]
        [:br]
        [themes/production-self]
        [:button {:type :button
                  :on-click #(on-route :truncate)} "Continue"]]]])))

(defn WeDo [{:keys [on-route]}]
  [title (title-attrs "We do")])

(defn YouDo [{:keys [on-route]}]
  [title (title-attrs "You do")])

(defn CurrentView []
  #_{:clj-kondo/ignore [:unresolved-symbol]}
  (r/with-let [view (r/atom :truncate)
               change-view {:on-route #(reset! view %)}]
    (case @view
      :splash [Splash change-view]
      :i-do [IDo change-view]
      :we-do [WeDo change-view]
      :you-do [YouDo change-view]
      :truncate [trunc/rewrite-melville])))