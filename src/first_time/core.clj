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

(defroutes app
  (GET "/" [] (generate-string {:success true :error nil}))
  (route/not-found (generate-string {:success false :error "route-not-found"})))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (reset! server (run-server #'app {:port 8080}))
  (println "Server Running"))
