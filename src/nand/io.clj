(ns nand.io)

(defn serialize
  "Print a data structure to a file so that we may read it in later."
  [filename data]
  (with-open [w (clojure.java.io/writer filename)]
    (binding [*out* w]
      (pr data))))

(defn deserialize
  "Read a data structure from edn (e.g. data.clj)"
  [filename]
  (with-open [r (java.io.PushbackReader. (clojure.java.io/reader filename))]
    (binding [*read-eval* false]
      (read r))))

(defn read-csv
  [path parse-line]
  (with-open [rdr (clojure.java.io/reader path :encoding "UTF-8")]
    (->> (line-seq rdr)
         (drop 1) ; skip header line
         (map parse-line)
         (doall))))
