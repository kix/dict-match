(ns clj-test-task.core
  (:require [clojure.java.io :as io]))

(defn try-fn [_]
  (== 1 (rand-int 2)))

(defn dictionary-attack [try-fn dict-path out-path]
  (with-open [r (io/reader dict-path)
              w (io/writer out-path)]
    (doseq [line (line-seq r)]
      (when (try-fn line)
        (.write w (str line "\n"))))))

(defn -main
  "Runs a dictionary attack given a dictionary file as first argument"
  [& [dict-path out-path]]
  (let [out-path (or out-path "out.txt")]
    (println "Using" dict-path "as dictionary, outputting matches to" out-path)
    (dictionary-attack try-fn dict-path out-path)
    (println "Done!")))
