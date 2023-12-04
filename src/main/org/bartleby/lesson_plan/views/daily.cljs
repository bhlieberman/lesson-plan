(ns org.bartleby.lesson-plan.views.daily
  (:require [re-com.core :refer [h-box hyperlink hyperlink-href v-box]]))

(defn summary []
  [h-box
   :justify :center
   :align :center
   :align-self :center
   :width "1000px"
   :children
   [[:table.table
     [:thead
      [:tr 
       [:th {:colspan "3"} "Context"]]
      [:tr 
       [:th {:scope "col"}
        "Course Title"]
       [:th {:scope "col"}
        "Unit Title"]
       [:th {:scope "col"}
        "Grade Level"]]]
     [:tbody
      [:tr
       [:td "English"]
       [:td "Reading \"Bartleby the Scrivener\""]
       [:td "12th grade"]]
      [:tr
       [:th {:scope "row"} "Desired Results"]
       [:td "CCSS.ELA-Literacy.RL.11-12.4
Determine the meaning of words and phrases as they are used in the text, including figurative and connotative meanings; analyze the impact of specific word choices on meaning and tone, including words with multiple meanings or language that is particularly fresh, engaging, or beautiful. (Include Shakespeare as well as other authors.)"]
       [:td "CCSS.ELA-Literacy.RL.11-12.2
Determine two or more themes or central ideas of a text and analyze their development over the course of the text, including how they interact and build on one another to produce a complex account; provide an objective summary of the text."]]]]]])

(defn DailyLesson [{:keys [on-route]}]
  [v-box
   :justify :center
   :align :center
   :align-self :center
   :width "1000px"
   :children
   [[:caption "Summary"]
    [summary]
    [:br] 
    [:caption "Daily Lesson Plan"]
    [:table.table
     [:thead
      [:tr
       [:th {:scope "col"} "Day"]
       [:th {:scope "col"} "Lesson Topic"]
       [:th {:scope "col"} "Learing Objectives"]
       [:th {:scope "col"} "Knowledge"]
       [:th {:scope "col"} "Skills"]
       [:th {:scope "col"} "Resources/Materials"]]]
     [:tbody
      [:tr#day1
       [:th {:scope "row"} "Day 1"]
       [:td "An overview of Romantic literature and art"]
       [:td "Students will achieve an understanding of what Romanticism is and its historical context."]
       [:td "Students will know how to identify particular aspects of Romantic literature, art, music,
           cite examples of prominent Romantic thinkers and artists."]
       [:td "Students can describe in writing and in speech the key elements of Romanticism."]
       [:td [hyperlink-href {:label "Romanticism, on Britannica"
                             :href "https://www.britannica.com/art/Romanticism"}]]]
      [:tr#day2
       [:th {:scope "row"} "Day 2"]
       [:td "Who was Herman Melville?"]
       [:td "Students will learn about the author of \"Bartleby the Scrivener\", his life, work, and legacy."]
       [:td "Students will know how \"Bartleby the Scrivener\" came to be written, and where stood Melville's career at the time."]
       [:td "Students will be able to situate Herman Melville in the context of Romanticism in general
           and American literature in particular."]
       [:td [hyperlink-href {:label "About Melville"
                             :href "https://www.poetryfoundation.org/poets/herman-melville"}]]]
      [:tr#day3 {:row-span "2"}
       [:th {:scope "row"} "Day 3"]
       [:td "Introduction to \"Bartleby the Scrivener\""]
       [:td "Students will learn about the assigned story."]
       [:td "Students will know what a scrivener is, their role in the operation of a law office,
           and other information important to their understanding of the story and its context."]
       [:td "Students will enumerate their understanding of the story thus far.
             Who is the narrator? Who are the supporting characters?
             They will discuss any unfamiliar or challenging aspects of the story,
             in particular any issues they have understanding Melville's style."]
       [:td
        [hyperlink {:label "The story"
                    :on-click #(on-route :story)}]
        [hyperlink-href {:label "Bartleby study guide"
                         :href "https://www.google.com/books/edition/A_Study_Guide_for_Herman_Melville_s_Bart/aWGqCgAAQBAJ?hl=en&gbpv=1&dq=Bartleby,+the+Scrivener&pg=PT8&printsec=frontcover"}]]]
      [:tr#day4
       [:th {:scope "row"} "Day 4"]
       [:td "Discussion of first third of the story"]
       [:td "The teacher will describe the process of identifying themes and other textual information from the tale,
             and how to provide supporting evidence for these. Students will participate in a group discussion of the relevant
             themes of the story."]
       [:td "Students will know about some of the core themes of \"Bartleby\"."]
       [:td "Students will be able to discover other themes in the text
             and write about them, corroborating them with quotations and excerpts."]]
      [:tr#day5
       [:th {:scope "row"} "Day 5"]
       [:td "On isolation"]
       [:td "The students will describe how Bartleby is isolated from the other staff of the law office,
             and how he both imposes this isolation on himself and also has it imposed on him."]
       [:td "Students will know what Bartleby's position in the office is like, and how this
             both enforces his isolation and also lessens it."]
       [:td "Students will be able to relate their own experiences of feeling isolated in a job or classroom
             or other professional environment to Bartleby's experience in the office."]
       [:td]]
      [:tr#day6 {:row-span "4"}
       [:th {:scope "row"} "Day 6"]
       [:td "Discussion of the second third of the story"]
       [:td "Students will closely read the second third of the story in anticipation of a discussion
             about the plot points through the middle."]
       [:td "Students will know and be able to identify the characters in the story, the setting, and the plot thus far.
             Students will **describe** the main characters of the story,  and **compare** their relationships to each other, and to the narrative as a whole."] 
       [:td "Students will write a summary of the story, enumerating any vocabulary or content they don't
             understand in a written exposition of two to three paragraphs."]
       [:td]]
      [:tr#day7
       [:th {:scope "row"} "Day 7"]
       [:td "Professional and economic coercion"]
       [:td "Students will learn about examples of how jobs like Bartleby's require changes in behavior,
             demeanor, and character."]
       [:td "Students will know how to describe the nature of these changes."]
       [:td "Students will cite examples of these in the text, especially in the cases of the other clerks."]]
      [:tr#day8
       [:th {:scope "row"} "Day 8"]
       [:td "Discussion of the last third of the story"]
       [:td "Students will participate in a discussion of the remaining third of the story."]
       [:td "Students will know what happens to Bartleby, and why. Students by now should be
             familiar with the writing style of Melville, and know how to apply this understanding
             to other examples of writing and expression from the period."]
       [:td "Students will participate in small group discussions regarding the plot of the story.
             They will describe for each other how Bartleby's demeanor and actions have changed
             the other characters in the office, chiefly the narrator."]
       [:td]]
      [:tr#day9
       [:th {:scope "row"} "Day 9"]
       [:td "Who is Bartleby?"]
       [:td "Students will write an essay in which they describe an experience they have
             had in which a situation required them to change their attitude, or else
             someone assumed something about them that was not true."]
       [:td "Students will know why various situations require people to make assumptions about others'
             characters, actions, and emotions."]
       [:td "Studens will write the opening paragraph of the essay for review by the teacher."]
       [:td]]
      [:tr#day10
       [:th {:scope "row"} "Day 10"]
       [:td "A fun capstone exercise"]
       [:td "Students will participate in a \"modern\" rewriting of Melville."]
       [:td "Students will know about methods for rephrasing the baroque prose of Melville
             in simple, modern terms."]
       [:td "Students will rephrase Melville's prose in simpler terms to gain an understanding of complex grammatical structures."]
       [:td [hyperlink {:label "Rewriting Melville"
                        :on-click #(on-route :truncate)}]]]]]]])