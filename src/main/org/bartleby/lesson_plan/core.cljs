(ns org.bartleby.lesson-plan.core
  (:require
   [goog.dom :as gdom]
   [org.bartleby.lesson-plan.views.grr :as views]
   [reagent.core :as r]
   [reagent.dom.client :as rdc]))

(defonce root (rdc/create-root (gdom/getElement "root")))

(defn ^:dev/after-load render []
  (rdc/render root (r/as-element [views/CurrentView])))

(defn init []
  (render))
