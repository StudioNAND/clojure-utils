(ns nand.network
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))


(defn request-json [url]
  (parse-string ((client/get url {:accept :json}) :body) true))
