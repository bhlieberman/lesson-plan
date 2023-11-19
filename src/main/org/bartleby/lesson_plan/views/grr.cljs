(ns org.bartleby.lesson-plan.views.grr
  (:require [goog.string :as gstr]
            [goog.object :as gobj]
            [org.bartleby.lesson-plan.views.navbar :refer [navbar]]
            [org.bartleby.lesson-plan.views.notes :refer [view-markdown]]
            [org.bartleby.lesson-plan.views.themes :as themes]
            [org.bartleby.lesson-plan.views.truncate :as trunc]
            [reagent.core :as r]
            [re-com.core :refer [button
                                 hyperlink
                                 title v-box]]
            ["react" :refer (createRef)]
            ["react-bootstrap" :refer [ListGroup]]))

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
        list-items-active? (r/atom [false false false])
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
        [:> ListGroup
         [:> (.-Item ListGroup) {:on-click (fn [_] (reset! list-items-active? [true false false]))
                                 :active (nth @list-items-active? 0)}
          [hyperlink {:on-click (fn [_] (.. list-item-1-ref -current scrollIntoView))
                      :label "Isolation"
                      :style {:color (if (nth @list-items-active? 0) "white" "blue")}}]]
         [:> (.-Item ListGroup) {:on-click (fn [_] (reset! list-items-active? [false true false]))
                                 :active (nth @list-items-active? 1)}
          [hyperlink {:on-click (fn [e] (.. list-item-2-ref -current scrollIntoView))
                      :label "Professional and economic coercion"
                      :style {:color (if (nth @list-items-active? 1) "white" "blue")}}]]
         [:> (.-Item ListGroup) {:on-click (fn [_] (reset! list-items-active? [false false true]))
                                 :active (nth @list-items-active? 2)}
          [hyperlink {:on-click (fn [e] (.. list-item-3-ref -current scrollIntoView))
                      :label "The \"production of the self\""
                      :style {:color (if (nth @list-items-active? 2) "white" "blue")}}]]]
        [:div.container-md.m-4.d-flex.flex-column
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
         [:br]
         [:button.btn.btn-primary.w-25.align-self-center
          {:type :button
           :on-click #(on-route :truncate)} "Continue"]]]])))

(defn WeDo [{:keys [on-route]}]
  [title (title-attrs "We do")])

(defn YouDo [{:keys [on-route]}]
  [title (title-attrs "You do")])

(defn CurrentView []
  #_{:clj-kondo/ignore [:unresolved-symbol]}
  (r/with-let [view (r/atom :i-do)
               change-view {:on-route #(reset! view %)}]
    [:div [navbar view]
     (case @view
       :splash [Splash change-view]
       :i-do [IDo change-view]
       :we-do [WeDo change-view]
       :you-do [YouDo change-view]
       :notes [view-markdown]
       :truncate [trunc/rewrite-melville])]))