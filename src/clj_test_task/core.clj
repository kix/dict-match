(ns clj-test-task.core
  (:require [clojure.java.io :as io]
            [clojure.core.async :refer [chan <! put! go go-loop]]))

(defn try-fn
  "Mock function. Randomly returns true or false for now."
  [_]
  (= 1 (rand-int 2)))

(defn dictionary-attack
  "Puts lines from dict-path that match try-fn to out-path"
  [try-fn dict-path out-path]
  (let [ch (chan)]
   (with-open [r (io/reader dict-path)]
     (doall (pmap
             #(put! ch %)
             (line-seq r))))
   (go-loop []
     (when-let [password (<! ch)]
       (when (try-fn password)
         (spit out-path (str password "\n") :append true))
       (recur)))))

(defn -main
  "Runs a dictionary attack given a dictionary file"
  [& [dict-path out-path]]
  (let [out-path (or out-path "out.txt")]
    (io/delete-file out-path)
    (if (.exists (io/file dict-path))
      (do
        (println "Using" dict-path "as dictionary, outputting matches to" out-path)
        (dictionary-attack try-fn dict-path out-path))
      (println "Dict does not exist at" dict-path))))
