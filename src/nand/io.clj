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
