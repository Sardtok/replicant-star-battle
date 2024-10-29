(ns user
  (:require [clojure.java.process :as proc]
            [clojure.string :as s]))

(defn require-shadow []
  (require '[shadow.cljs.devtools.api :as shadow]
           '[shadow.cljs.devtools.server :as shadow-server]))

(defn cljs-repl
  "Connects to a given build-id. Defaults to `:app`."
  ([]
   (cljs-repl :app))
  ([build-id]
   (require-shadow)
   (let [start-server! (resolve 'shadow-server/start!)
         watch (resolve 'shadow/watch)
         nrepl-select (resolve 'shadow/nrepl-select)]
     (when (and start-server! watch nrepl-select)
       (start-server!)
       (watch build-id)
       (nrepl-select build-id)))))
