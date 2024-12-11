(ns chickensoft.star-battle.grid
  (:require [chickensoft.star-battle.components.grid :as grid]
            [chickensoft.star-battle.core :as sb]
            [portfolio.replicant :refer [defscene]]))

(defscene grid-5x5
          :param (atom {:board [[{:region 1 :content :mark} {:region 2 :content :mark} {:region 3 :content :mark} {:region 3 :content nil} {:region 3 :content nil}]
                                [{:region 1 :content :mark} {:region 2 :content :star} {:region 2 :content :mark} {:region 4 :content :mark} {:region 5 :content :mark}]
                                [{:region 1 :content :mark} {:region 1 :content :mark} {:region 2 :content :mark} {:region 4 :content nil} {:region 5 :content nil}]
                                [{:region 1 :content nil} {:region 4 :content :mark} {:region 4 :content nil} {:region 4 :content nil} {:region 5 :content nil}]
                                [{:region 1 :content nil} {:region 1 :content :mark} {:region 5 :content nil} {:region 5 :content nil} {:region 5 :content nil}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])

(defscene grid-6x6
          :param (atom {:board [[{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])

(defscene grid-7x7
          :param (atom {:board [[{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])

(defscene grid-8x8
          :param (atom {:board [[{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])

(defscene grid-9x9
          :param (atom {:board [[{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])

(defscene grid-10x10
          :param (atom {:board [[{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]
                                [{:region 1} {:region 2} {:region 3} {:region 4} {:region 5} {:region 6} {:region 7} {:region 8} {:region 9} {:region 10}]]})
          [state]
          [:div.game (grid/render (sb/prepare-board (:board @state)))])
