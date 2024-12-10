(ns chickensoft.star-battle.portfolio
  (:require [chickensoft.star-battle.grid]
            [chickensoft.star-battle.cell]
            [portfolio.ui.search :as search]
            [portfolio.ui :as ui]))

(defn init []
  (ui/start!
    {:config
     {:css-paths ["/style.css"]}
     :index (search/create-index)}))
