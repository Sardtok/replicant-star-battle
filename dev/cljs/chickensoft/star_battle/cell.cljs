(ns chickensoft.star-battle.cell
  (:require [chickensoft.star-battle.components.cell :as cell]
            [chickensoft.star-battle.core :as sb]
            [portfolio.replicant :refer [defscene]]))

(defscene cell-region-1
          :param (atom [[{:region 1}]])
          [state]
          (let [cell-hiccup (cell/render (sb/prepare-cell @state 0 0))]
            [:div.game
             [:div {:style {:width 200 :height 200 :margin-bottom 10}} cell-hiccup]
             [:div {:style {:width 100 :height 100 :margin-bottom 10}} cell-hiccup]
             [:div {:style {:width 50 :height 50 :margin-bottom 10}} cell-hiccup]]))

(defscene cell-region-2
          :param (atom [[{:region 2}]])
          [state]
          (let [cell-hiccup (cell/render (sb/prepare-cell @state 0 0))]
            [:div.game
             [:div {:style {:width 200 :height 200 :margin-bottom 10}} cell-hiccup]
             [:div {:style {:width 100 :height 100 :margin-bottom 10}} cell-hiccup]
             [:div {:style {:width 50 :height 50 :margin-bottom 10}} cell-hiccup]]))
