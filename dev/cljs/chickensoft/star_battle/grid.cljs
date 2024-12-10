(ns chickensoft.star-battle.grid
  (:require [chickensoft.star-battle.components.grid :as grid]
            [chickensoft.star-battle.core :as sb]
            [portfolio.replicant :refer [defscene]]))

(defscene grid-5x5
          :param (atom {:board [[{:region 1 :content :mark} {:region 2 :content nil} {:region 3 :content nil} {:region 3 :content :mark} {:region 3 :content nil}]
                                [{:region 1 :content nil} {:region 2 :content nil} {:region 2 :content :mark} {:region 4 :content :mark} {:region 5 :content nil}]
                                [{:region 1 :content :mark} {:region 1 :content nil} {:region 2 :content nil} {:region 4 :content nil} {:region 5 :content nil}]
                                [{:region 1 :content nil} {:region 4 :content nil} {:region 4 :content nil} {:region 4 :content nil} {:region 5 :content nil}]
                                [{:region 1 :content nil} {:region 1 :content nil} {:region 5 :content nil} {:region 5 :content nil} {:region 5 :content nil}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])
