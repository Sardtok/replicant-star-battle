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

(defn build-cljs-if-changed
  "Builds a release build of the CLJS code and adds it to the commit
   if any CLJS files have been changed in the commit."
  [& args]
  (let [git-staged-proc (proc/start "git" "diff" "--cached" "--name-only")
        git-staged-cljs (-> (proc/stdout git-staged-proc)
                            slurp
                            (s/split #"\R")
                            (->> (filter #(re-find #"\.clj[sc]$" %))))]
    (when (seq git-staged-cljs)
      (println "CLJS has changed. Building release and adding to commit.")
      (try
        (require-shadow)
        (catch Exception _
          (.println *err* "Could not load shadow. Run with clj -X:dev:shadow user/build-cljs-if-changed")
          (System/exit 1)))
      (let [release (resolve 'shadow/release)]
        (release :app)
        @(proc/exit-ref (proc/start "git" "add" "resources/js/main.js"))))))
