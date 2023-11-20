(ns org.bartleby.lesson-plan.views.Splash
  (:require [goog.string :as gstr]
            [re-com.core :refer [v-box title button]]))

(defn title-attrs [label] {:label label
                           :level :level2
                           :margin-top "2px"
                           :margin-bottom "10px"})

(defn Splash [{:keys [on-route]}]
  [v-box
   :height "200px"
   :children
   [[v-box
     :justify :center
     :align :center
     :margin "auto"
     :children
     [[:figure.text-center
       [:blockquote.blockquote
        [:p "I would prefer not to."]]
       [:figcaption.blockquote-footer
        "Bartleby, in " [:cite {:title "Bartleby the Scrivener"} "Bartleby the Scrivener"]]] 
      [:button.btn.btn-primary
       {:on-click #(on-route :i-do)} "Enter"]]]]])