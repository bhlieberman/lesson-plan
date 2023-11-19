(ns org.bartleby.lesson-plan.views.navbar)

(defn navbar [current-route]
  [:nav {:class "navbar navbar-expand-lg bg-body-tertiary"}
   [:div {:class "container-fluid"}
    [:a {:class "navbar-brand", :href "#"} "Lesson plan"]
    [:button {:class "navbar-toggler", :type "button", :data-bs-toggle "collapse", :data-bs-target "#navbarNav", :aria-controls "navbarNav", :aria-expanded "false", :aria-label "Toggle navigation"}
     [:span {:class "navbar-toggler-icon"}]]
    [:div {:class "collapse navbar-collapse", :id "navbarNav"}
     [:ul {:class "navbar-nav"}
      [:li {:class "nav-item"}
       [:a {:class "nav-link active", :aria-current "page", :href "#"
            :on-click #(reset! current-route :splash)} "Home"]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link", :href "#"
            :on-click #(reset! current-route :notes)} "Notes"]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link", :href "#"
            :on-click #(reset! current-route :i-do)} "I do"]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link disabled", :aria-disabled "true"
            :on-click #(reset! current-route :you-do)} "You do"]]]]]])