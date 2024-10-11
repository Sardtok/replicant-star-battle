(ns chickensoft.star-battle
  (:require [org.httpkit.server :as server]))

(defn handler [req]
  {:handler 200
   :body "The battle is commencing soon."})

(defn start-server! []
  (server/run-server #'handler {:legacy-return-value? false
                                :port 7777}))

(defn -main
  "Start the http-kit webserver"
  [& _]
  (start-server!))
