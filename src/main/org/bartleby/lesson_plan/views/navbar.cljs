(ns org.bartleby.lesson-plan.views.navbar)

(defn navbar [current-route]
  [:nav {:class "navbar navbar-expand-lg bg-body-tertiary"}
   [:div {:class "container-fluid"}
    [:a {:class "navbar-brand", :href "#"} [:b "Lesson plan"]]
    [:button {:class "navbar-toggler", :type "button", :data-bs-toggle "collapse", :data-bs-target "#navbarNav", :aria-controls "navbarNav", :aria-expanded "false", :aria-label "Toggle navigation"}
     [:span {:class "navbar-toggler-icon"}]]
    [:div {:class "collapse navbar-collapse", :id "navbarNav"}
     [:ul {:class "navbar-nav"}
      [:li {:class "nav-item"}
       [:a {:class "nav-link active", :aria-current "page", :href "#"
            :on-click #(reset! current-route :splash)} (if (= :home @current-route) [:u "Home"] "Home")]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link active", :aria-current "page", :href "#"
            :on-click #(reset! current-route :story)} (if (= :story @current-route) [:u "The story"] "The story")]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link"
            :on-click #(reset! current-route :daily)} (if (= :daily @current-route) [:u "Daily Lesson Plan"] "Daily lesson plan")]] 
      [:li {:class "nav-item"}
       [:a {:class "nav-link", :href "#"
            :on-click #(reset! current-route :i-do)} (if (= :i-do @current-route) [:u "I do"] "I do")]]
      [:li {:class "nav-item"}
       [:a {:class "nav-link", :aria-disabled "true"
            :on-click #(reset! current-route :truncate)} (if (= :truncate @current-route) [:u "You do"] "You do")]]]]]])