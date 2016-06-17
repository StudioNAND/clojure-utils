(ns nand.parse
  (:require [clj-time.format :as f]))

(defn parse-int [s]
  (try (Integer/parseInt s) (catch NumberFormatException e nil)))

(defn parse-date [s]
  (try (f/parse (f/formatters :date-time-no-ms) s) (catch Exception e nil)))

(defn encode-date [s]
  (f/unparse (f/formatters :date-time-no-ms) s))

(defn parse-string [s]
  (if (empty? s) nil s))
