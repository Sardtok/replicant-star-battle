(ns chickensoft.star-battle
  (:require [clojure.string :as s]
            [org.httpkit.server :as server]
            [ring.middleware.content-type :as content-type-mw]
            [ring.middleware.file :as file-mw]
            [ring.middleware.not-modified :as not-modified-mw]
            [ring.util.response :as ring-response])
  (:import (java.io File)))

(defn- add-content-type-if-index-html [response]
  (if (and (instance? File (:body response))
           (-> response :body .getName (s/ends-with? "index.html")))
    (ring-response/content-type response "text/html")
    response))

(defn wrap-index-html-content-type
  [handler]
  (fn
    ([request] (-> request handler add-content-type-if-index-html))
    ([request respond raise]
     (-> request (handler (fn [response] (-> response add-content-type-if-index-html respond)) raise)))))

(def handler
  (-> (fn api-handler [req] nil)
      (file-mw/wrap-file "resources")
      wrap-index-html-content-type
      content-type-mw/wrap-content-type
      not-modified-mw/wrap-not-modified))

(defn start-server! []
  (server/run-server #'handler {:legacy-return-value? false
                                :port 7777}))

(defn -main
  "Start the http-kit webserver"
  [& args]
  (println "Starting server on port 7777")
  (start-server!)
  (println "http-kit server is running"))
