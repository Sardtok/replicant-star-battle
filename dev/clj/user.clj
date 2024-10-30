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

(defn- run-cmd-or-exit-with-error-msg [error-msg & cmd]
  (when (not= 0 @(proc/exit-ref (apply proc/start cmd)))
    (println error-msg)
    (System/exit 1)))

(defn deploy-app
  "Builds a release build of the CLJS code and deploys the app to application.garden."
  [& args]
  (try
    (require-shadow)
    (catch Exception _
      (.println *err* "Could not load shadow. Run with clj -X:dev:shadow user/deploy-app")
      (System/exit 1)))

  (run-cmd-or-exit-with-error-msg "Could not stash changes."
                                  "git" "stash")

  (let [release (resolve 'shadow/release)]
    (release :app))

  (run-cmd-or-exit-with-error-msg "Could not add JS."
                                  "git" "add" "--force" "resources/js/main.js")
  (run-cmd-or-exit-with-error-msg "Could not commit JS."
                                  "git" "commit" "-m" "Release")

  (run-cmd-or-exit-with-error-msg "Could not deploy to App Garden"
                                  "garden" "deploy")

  (run-cmd-or-exit-with-error-msg "Could not reset changes."
                                  "git" "reset" "--hard" "HEAD~")
  (run-cmd-or-exit-with-error-msg "Could not pop stashed changes."
                                  "git" "stash" "pop"))
