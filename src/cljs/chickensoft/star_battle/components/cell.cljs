(ns chickensoft.star-battle.components.cell)

(defn render [{:keys [region-class is-marked? is-starred?]}]
      [:div {:class [:cell region-class (when is-marked? "marked")]}
       (when is-starred? [:img {:src "/images/star.svg"}])])
