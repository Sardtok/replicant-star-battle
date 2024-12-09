(ns chickensoft.star-battle.core
  (:require [replicant.dom :as dom]
            [chickensoft.star-battle.components.grid :as grid]
            [clojure.pprint :as pprint]))

(def db (atom {:board [[{:region 1 :content :mark} {:region 2 :content nil} {:region 3 :content nil} {:region 3 :content :mark} {:region 3 :content nil}]
                       [{:region 1 :content nil} {:region 2 :content nil} {:region 2 :content :mark} {:region 4 :content :mark} {:region 5 :content nil}]
                       [{:region 1 :content :mark} {:region 1 :content nil} {:region 2 :content nil} {:region 4 :content nil} {:region 5 :content nil}]
                       [{:region 1 :content nil} {:region 4 :content nil} {:region 4 :content nil} {:region 4 :content nil} {:region 5 :content nil}]
                       [{:region 1 :content nil} {:region 1 :content nil} {:region 5 :content nil} {:region 5 :content nil} {:region 5 :content nil}]]}))

(defn prepare-cell [cell]
      (let [{:keys [region content]} cell]
        {:type :cell
         :region-class (str "region-" region)
         :is-marked? (= :mark content)
         :is-starred? (= :star content)}))

(defn prepare-row [row]
      {:type :row
       :cells (map prepare-cell row)})

(defn prepare-board [board]
      (let [size (count board)]
           (assert (every? #(= size (count %)) board)
                   "Unbalanced board xxx")
           {:type :grid
            :size-class (str "grid-" size "x" size)
            :rows (map prepare-row board)}))

(defn ^:export
      ^:dev/after-load
      run []
      (let [prepared (prepare-board (:board @db))]
           (dom/render
             (.getElementById js/document "root")
             [:div.game (grid/render prepared)]
             )))
