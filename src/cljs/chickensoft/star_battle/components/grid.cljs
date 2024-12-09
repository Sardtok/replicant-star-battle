(ns chickensoft.star-battle.components.grid
      (:require [chickensoft.star-battle.components.row :as row]))

(defn render [{:keys [size-class rows]}]
      [:div {:class [:grid size-class]}
       (map row/render rows)])
