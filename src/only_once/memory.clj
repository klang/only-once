(ns only-once.memory)

(def ^:dynamic *drop* (ref {}))

(defn mset [key value]
  (dosync (alter *drop* assoc key value) nil))
(defn mget [key]
  (dosync
   (let [return (@*drop* key)]
     (alter *drop* dissoc key)
     return)))

;;(mset "key" {:name "klang" :value "foo"})
;;(mget "key")
;;@*drop*
