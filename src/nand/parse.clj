(ns nand.parse
  (:require [clj-time.format :as f]
            [clojure.string :as str]))

(defn empty->nil
  "Returns nil if `s` is empty, otherwise returns s."
  [s]
  (if (empty? s) nil s))

(defn parse-int [s]
  (if (empty? s) nil (Integer/parseInt s)))

(defn parse-float [s]
  (if (empty? s) nil (Float/parseFloat s)))

(defn parse-date
  "
  Converts a String object in JDBC timestamp escape format to a Timestamp value.
  https://docs.oracle.com/javase/7/docs/api/java/sql/Timestamp.html
  "
  [s]
  (java.sql.Timestamp/valueOf s))

(defn parse-datetime [s]
  (f/parse (f/formatters :date-time-no-ms) s))

(defn encode-datetime [s]
  (f/unparse (f/formatters :date-time-no-ms) s))

(defn parse-string [s]
  (if (empty? s) nil s))

(defn parse-list [s re field-fn]
  (->> (str/split s re)
       (map field-fn)))

(defn parse-strings [s]
  (parse-list s #"," empty->nil))
