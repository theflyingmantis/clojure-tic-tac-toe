(ns first-time.core
  (:gen-class)
  (:require [org.httpkit.server :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :refer :all])
  )

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defonce server (atom nil))
(defonce board (atom {}))

(defn get-board [] @board)

(defn get-position [x y] (+ (* 3 x) y))

(defroutes app
  (GET "/" [] (generate-string {:data get-board :error nil}))
  (route/not-found (generate-string {:data nil :error "route-not-found"})))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (reset! server (run-server #'app {:port 8080}))
  (println "Server Running"))
