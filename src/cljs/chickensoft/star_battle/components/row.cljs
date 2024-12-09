(ns chickensoft.star-battle.components.row
      (:require [chickensoft.star-battle.components.cell :as cell]
                [clojure.pprint :as pprint]))

(defn render [{:keys [cells]}]
      [:div.row
       (map cell/render cells)])
