(ns nand.parse
  (:require [clj-time.format :as f]))

(defn parse-int [s]
  (try (Integer/parseInt s) (catch NumberFormatException e nil)))

(defn parse-date
  "
  Converts a String object in JDBC timestamp escape format to a Timestamp value.
  https://docs.oracle.com/javase/7/docs/api/java/sql/Timestamp.html
  "
  [s]
  (java.sql.Timestamp/valueOf s))

(defn encode-date [s]
  (f/unparse (f/formatters :date-time-no-ms) s))

(defn parse-string [s]
  (if (empty? s) nil s))
