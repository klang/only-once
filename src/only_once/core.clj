(ns only-once.core
  (:use [ring.adapter.jetty :only (run-jetty)]
        [only-once.web-view :only (app)]
        [clojure.tools.cli  :only (cli)]
        [only-once.utils    :only (to-int)])
  (:gen-class))

(defonce web-server (atom nil))

(defn -main [& args]
  (let [host (try (.getHostAddres (java.net.InetAddress/getLocalHost)) 
                  (catch java.net.UnknownHostException e "127.0.0.1"))
        [options _ banner]
        (cli args
             ["--http-port" "starts jetty on http-port" :default (int 8080) :parse-fn to-int])]
    (do (reset! web-server (run-jetty
                            #'only-once.web-view/app
                            {:port (options :http-port) :join? false}))
        (println "\nJetty http-server started on"host":" (options :http-port))))
  )