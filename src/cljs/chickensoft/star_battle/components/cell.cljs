(ns chickensoft.star-battle.components.cell)

(defn render [{:keys [classes img]}]
      [:div {:class (into [:cell] classes)}
       (when img [:img {:src img}])])
