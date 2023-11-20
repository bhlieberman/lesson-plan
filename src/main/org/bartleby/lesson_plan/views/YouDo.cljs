(ns org.bartleby.lesson-plan.views.YouDo
  (:require [re-com.core :refer [title]]))

(defn title-attrs [label] {:label label
                           :level :level2
                           :margin-top "2px"
                           :margin-bottom "2px"})

(defn YouDo [{:keys [on-route]}]
  [title (title-attrs "You do")])