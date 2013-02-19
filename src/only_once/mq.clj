(ns only-once.mq
  (:require [taoensso.carmine :as car])
  (:require [taoensso.carmine.message-queue :as carmine-mq]))

(def pool         (car/make-conn-pool))
(def spec-server1 (car/make-conn-spec))
(defmacro wcar [& body] `(car/with-conn pool spec-server1 ~@body))
(defn mset [key value] (wcar (car/set key value)) nil)
(defn mget [key] (first (wcar (car/get key) (car/del key))))
