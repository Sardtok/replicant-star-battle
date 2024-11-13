(ns chickensoft.star-battle.core
  (:require [replicant.dom :as dom]))

(defn ^export run []
      (dom/render
        (.getElementById js/document "root")
        [:div
         [:h1 "Star Battle"]
         [:div.game
          [:div.grid.grid-5x5
           [:div.row
            [:div.cell.region-1]
            [:div.cell.region-2]
            [:div.cell.region-3]
            [:div.cell.region-3]
            [:div.cell.region-3]]
           [:div.row
            [:div.cell.region-1]
            [:div.cell.region-2]
            [:div.cell.region-2]
            [:div.cell.region-4]
            [:div.cell.region-5]]
           [:div.row
            [:div.cell.region-1]
            [:div.cell.region-1]
            [:div.cell.region-2]
            [:div.cell.region-4]
            [:div.cell.region-5]]
           [:div.row
            [:div.cell.region-1]
            [:div.cell.region-4]
            [:div.cell.region-4]
            [:div.cell.region-4]
            [:div.cell.region-5]]
           [:div.row
            [:div.cell.region-1]
            [:div.cell.region-1]
            [:div.cell.region-5]
            [:div.cell.region-5]
            [:div.cell.region-5]]]]]))
