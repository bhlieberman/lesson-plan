(ns org.bartleby.lesson-plan.views.grr
  (:require [org.bartleby.lesson-plan.views.navbar :refer [navbar]] 
            [org.bartleby.lesson-plan.views.IDo :refer [IDo]]
            [org.bartleby.lesson-plan.views.WeDo :refer [WeDo]] 
            [org.bartleby.lesson-plan.views.Splash :refer [Splash]]
            [org.bartleby.lesson-plan.views.story :refer [story]]
            [org.bartleby.lesson-plan.views.truncate :as trunc]
            [org.bartleby.lesson-plan.views.daily :as daily]
            [reagent.core :as r]))

(defn CurrentView []
  #_{:clj-kondo/ignore [:unresolved-symbol]}
  (r/with-let [view (r/atom :splash)
               change-view {:on-route #(reset! view %)}]
    [:div.d-flex.flex-column [navbar view]
     (case @view
       :splash [Splash change-view]
       :i-do [IDo change-view]
       :we-do [WeDo change-view] 
       :story [story]
       :daily [daily/DailyLesson change-view]
       :truncate [trunc/rewrite-melville])]))