(ns org.bartleby.lesson-plan.views.notes
  (:require [shadow.resource :refer [inline]]
            ["markdown-to-jsx" :as Markdown]
            ["react-bootstrap" :refer [ListGroup]]))

(defn view-markdown []
  (let [md (inline "Notes.md")]
    [:div.container-md
     [:section#lesson-notes.d-flex.flex-column
      [:h2.align-self-center "Lesson Plan Notes"]
      [:> Markdown {:options
                    {:overrides
                     {:ul {:component ListGroup}
                      :li {:component (.-Item ListGroup)}}}} md]]]))