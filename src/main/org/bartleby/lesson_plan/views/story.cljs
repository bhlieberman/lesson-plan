(ns org.bartleby.lesson-plan.views.story
  (:require [reagent.core :as r]
            [re-com.core :refer [throbber v-box]]))

(defn story []
  (r/with-let [show-throbber? (r/atom false)]
    (if @show-throbber?
      [throbber]
      [:div.d-flex.flex-column.align-items-center.justify-content-center
       [:object.align-self-center {:data "https://moglen.law.columbia.edu/LCS/bartleby.pdf"
                                   :type "application/pdf"
                                   :width 500 :height 800
                                   :on-load #(swap! show-throbber? (fn [curr] (when curr (not curr))))}]
       [:div#melville-bio.d-flex.flex-column.align-self-center
        [v-box
         :class "align-items-center m-2"
         :children
         [[:br]
          [:img.w-25.h-25 {:src "/assets/images/melville.jpg"}]
          [:h3.mt-2 "Herman Melville: (1819-1891)"]
          [:section#bio
           [:p.lead "Herman Melville, author of \"Bartleby the Scrivener\" and numerous
                 other vital works of American literature..."]]]]]])))