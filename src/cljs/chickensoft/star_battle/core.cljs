(ns chickensoft.star-battle.core
  (:require [replicant.dom :as dom]
            [chickensoft.star-battle.components :as components]
            [chickensoft.star-battle.components.grid :as grid]
            [clojure.pprint :as pprint]))

(def db (atom {}))

(defn prepare-cell [board row col]
      (let [{:keys [region content]} (get-in board [row col])]
        {::components/kind ::components/cell
         :classes [(str "region-" region)
                   (when (not= region (get-in board [(dec row) col :region]))
                     :other-region-top)
                   (when (not= region (get-in board [(dec row) (inc col) :region]))
                     :other-region-top-right)
                   (when (not= region (get-in board [row (inc col) :region]))
                     :other-region-right)
                   (when (not= region (get-in board [(inc row) (inc col) :region]))
                     :other-region-bottom-right)
                   (when (not= region (get-in board [(inc row) col :region]))
                     :other-region-bottom)
                   (when (not= region (get-in board [(inc row) (dec col) :region]))
                     :other-region-bottom-left)
                   (when (not= region (get-in board [row (dec col) :region]))
                     :other-region-left)
                   (when (not= region (get-in board [(dec row) (dec col) :region]))
                     :other-region-top-left)
                   (when (= content :mark) :marked)]
         :img (when (= content :star) "/images/star.svg")}))

(defn prepare-row [board row]
  {::components/kind ::components/row
   :cells (map-indexed (fn [column _cell] (prepare-cell board row column))
                       (get board row))})

(defn prepare-board [board]
  (let [size (count board)]
    (assert (every? #(= size (count %)) board)
            "Unbalanced board xxx")
    {::components/kind ::components/grid
     :size-class (str "grid-" size "x" size)
     :rows (map-indexed (fn [row _contents] (prepare-row board row))
                        board)}))

(defn ^:export
  ^:dev/after-load
  run []
  (let [prepared (prepare-board (:board @db))]
    (dom/render
      (.getElementById js/document "root")
             [:div.game (grid/render prepared)]
             )))
