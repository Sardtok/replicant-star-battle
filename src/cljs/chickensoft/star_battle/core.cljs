(ns chickensoft.star-battle.core
      (:require [replicant.dom :as dom]))

(defn ^export run []
      (dom/render
            (.getElementById js/document "root")
            [:div
             [:h1 "Star Battle"]
             [:div.game]]))
