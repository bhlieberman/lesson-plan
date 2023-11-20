(ns org.bartleby.lesson-plan.views.grr
  (:require [org.bartleby.lesson-plan.views.navbar :refer [navbar]]
            [org.bartleby.lesson-plan.views.notes :refer [view-markdown]]
            [org.bartleby.lesson-plan.views.story :refer [story]]
            [org.bartleby.lesson-plan.views.IDo :refer [IDo]]
            [org.bartleby.lesson-plan.views.WeDo :refer [WeDo]]
            [org.bartleby.lesson-plan.views.YouDo :refer [YouDo]]
            [org.bartleby.lesson-plan.views.Splash :refer [Splash]]
            [org.bartleby.lesson-plan.views.truncate :as trunc]
            [reagent.core :as r]))

(defn CurrentView []
  #_{:clj-kondo/ignore [:unresolved-symbol]}
  (r/with-let [view (r/atom :splash)
               change-view {:on-route #(reset! view %)}]
    [:div [navbar view]
     (case @view
       :splash [Splash change-view]
       :i-do [IDo change-view]
       :we-do [WeDo change-view]
       :you-do [YouDo change-view]
       :notes [view-markdown]
       :story [story]
       :truncate [trunc/rewrite-melville])]))