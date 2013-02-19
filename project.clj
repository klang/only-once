(defproject only-once "0.1.0-SNAPSHOT"
  :description "a small _insecure_ service that let you drop a value and get it back later. security by obscurity"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/tools.cli "0.2.2"] ;; https://github.com/clojure/tools.cli
                 ;;web
                 [ring "1.1.0"]
		 [compojure "1.0.2"]
		 [hiccup "1.0.0"]]
  :main only-once.core
  :jvm-opts ["-Xmx64M"])
