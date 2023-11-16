(ns org.bartleby.lesson-plan.views.themes
  (:require [goog.string :as gstr]))

(defn intro []
  [:div.container-sm
   [:section.d-flex.flex-column.justify-content-center.align-items-center
    [:h2 "Introduction"]
    [:article.d-flex.flex-column.justify-content-center.align-items-center
     [:p.w-50 (gstr/truncate
               (str "I will demonstrate some simple examples of observing thematic elements in the story "
                    (gstr/quote "Bartleby the Scrivener")
                    " by Herman Melville. I have identified three important themes
        that I believe make for compelling analysis. After I have discussed my examples,
       we will do a similar activity together. Then, I will divide you up into groups and you will
       ") 360)]]]])

(defn isolation []
  [:div.container-sm
   [:section.d-flex.flex-column.justify-content-center.align-items-center
    [:h3.italic "Isolation"]
    [:article.d-flex.flex-column.justify-content-center.align-items-center
     [:p.lead "Bartleby is a mysterious figure about whose life and circumstances we know very little."]
     [:p.w-50 "Everything we know about him, and every other character in the story for that matter,
          we learn from the narrator, an unnamed lawyer who runs an office on Wall Street."]]]])

(defn coercion []
  [:div.container-sm
   [:section.d-flex.flex-column.justify-content-center.align-items-center
    [:h3.italic "Professional and economic coercion"]
    [:article.d-flex.flex-column.justify-content-center.align-items-center
     [:p.lead "The whole sad story is one of the gentle application of force."]
     [:p "Though the narrator is benevolent enough, a man who loves ease,
          he is perplexed by Bartleby's noncompliance:"]
     [:p.blockquote.bold (gstr/quote "Either you must do something, or something must be done to you.")]
     [:p.w-50 "Bartleby is not interested in the inducements of ordinary people. The other clerks each have their
          vices, Turkey his alcohol, and Nippers his choleric disposition, but Bartleby apparently has none.
          He is extremely mild-mannered, even when he is declining to do any labor."]]]])

(defn production-self []
  [:div.container-sm
   [:section.d-flex.flex-column.justify-content-center.align-items-center
    [:h3.italic "The Production of the self"]
    [:article.d-flex.flex-column.justify-content-center.align-items-center
     [:p.lead "How much of ourselves is determined by others?"]
     [:p.w-50 "The narrator, though he seems more or less humble, is really quite
          presumptuous when it comes to describing his clerks."]]]])