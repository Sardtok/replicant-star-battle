(ns chickensoft.star-battle
  (:require [clojure.string :as s]
            [org.httpkit.server :as server]
            [ring.util.response :as response]
            [shadow.cljs.devtools.api :as shadow]))

(defn handler [req]
  (let [path (subs (:uri req) 1)
        path (if (s/blank? path) "index.html" path)]
    (response/file-response path {:root "resources"})))

(defn start-server! []
  (server/run-server #'handler {:legacy-return-value? false
                                :port 7777}))

(defn -main
  "Start the http-kit webserver"
  [& args]
  (when-not (seq args)
    (println "Building release version of ClojureScript client code")
    (shadow/release! :cljs))
  (println "Starting server on port 7777")
  (start-server!)
  (println "http-kit server is running"))
