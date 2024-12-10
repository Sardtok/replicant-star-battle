(ns chickensoft.star-battle.components
  (:require [chickensoft.star-battle.components.cell :as cell]
            [chickensoft.star-battle.components.grid :as grid]
            [chickensoft.star-battle.components.row :as row]))

(defn- -render-component [component]
  (case (::kind component)
    ::cell (cell/render component)
    ::row (row/render component)
    ::grid (grid/render component)))

(defn render [component]
  (cond (sequential? component)
        (map render component)

        component
        (-render-component component)

        :else nil))
