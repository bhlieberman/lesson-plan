(ns org.bartleby.lesson-plan.views.IDo
  (:require [goog.string :as gstr] 
            [org.bartleby.lesson-plan.views.themes :as themes] 
            [reagent.core :as r]
            [re-com.core :refer [hyperlink title v-box]]
            ["react" :refer (createRef)]
            ["react-bootstrap" :refer [ListGroup]]))

(defn title-attrs [label] {:label label
                           :level :level2
                           :margin-top "2px"
                           :margin-bottom "2px"})

(defn IDo [{:keys [_on-route]}]
  (let [view-title (str "Themes of " (gstr/quote "Bartleby the Scrivener") " by Herman Melville")
        list-items-active? (r/atom [false false false])
        list-item-1-ref (createRef)
        list-item-2-ref (createRef)
        list-item-3-ref (createRef)]
    (fn [{:keys [on-route]}]
      [v-box
       :justify :center
       :align :center
       :children
       [[title (merge (title-attrs view-title)
                      {:level :level1
                       :style {:margin-top "20px"
                               :margin-bottom "20px"
                               :align-self :center}})]
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