(ns only-once.web-view
  (:use 
   compojure.core
   [hiccup core form]
   [hiccup.page :only (html5)]
   [hiccup.middleware :only (wrap-base-url)]
   [only-once.mq :only [mget mset]])
  (:require 
   [compojure.route :as route]
   [compojure.handler :as handler]
   (:gen-class)))

;; @only-once.memory/*drop*

(defroutes main-routes
  (GET "/" [] 
       (html5 
        (form-to 
         [:post "/drop"]
         "key to collect values from later:" (text-field :key) [:br]
         (text-field :value)
         (submit-button "drop"))))
  (ANY "/drop" [key value] 
        (do 
          (mset key value)
          (html5 
           [:pre (str key"="value)])))
  (GET "/:key" [key] 
       (html5 
        (let [value (mget key)]
          [:pre (if (nil? value) 
                  "you only get one shot" 
                  (str key "=" value))])))
  (route/files "/" {:root "resources/public"})
  (route/not-found (html5 [:h1 "Page Not Found!"])))

(def app (-> (handler/site main-routes)
             (wrap-base-url)))



