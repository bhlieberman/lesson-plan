(ns org.bartleby.lesson-plan.views.truncate
  (:require [goog.string :as gstr]
            [reagent.core :as r]))

(defn rewrite-melville []
  (let [text-input (r/atom "")
        original (r/atom "I answered nothing; but effectually dodging every one by the suddenness and rapidity of my flight, rushed from the building, ran up Wall-street towards Broad-way, and jumping into the first omnibus was soon removed from pursuit.")]
    (fn []
      [:div.d-flex.flex-column
       [:h1.align-self-center.m-4 "Interactive exercise"]
       [:p.align-self-center.bold "Original sentence: "]
       [:p.blockquote.w-25.align-self-center.text-center (gstr/quote @original)]
       [:p @text-input]
       [:label.bold.italic.align-self-center {:for "rewrite"} "Write your own version of the above sentence(s) here:"]
       [:textarea.w-50.align-self-center.m-4 {:id "rewrite"
                   :name "student"
                   :rows 10
                   :on-change #(reset! text-input (.. % -target -value))}]
       [:button.w-25.align-self-center {:type :button
                 :on-click #(reset! original @text-input)} "Rewrite!"]])))