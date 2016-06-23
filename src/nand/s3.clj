(ns nand.s3
  (:require [clojure.java.io :refer [reader]]
            [amazonica.core :refer :all]
            [amazonica.aws.s3 :as s3]
            [cheshire.core :refer :all]))

(defn upload-as-json
  "upload data to S3 bucket. Append .json file ending if not present
  to upload to folder, simply prepend foldername/ - S3 doesn't have folders
  but will show them if file keys contains paths"
  [bucket key data]
  (let [bytes (.getBytes (generate-string data))
        key (if-not (.endsWith key "json") (str key ".json") key)]
    (s3/put-object :bucket-name bucket
                   :key key
                   :input-stream (java.io.ByteArrayInputStream. bytes)
                   :metadata {:content-length (count bytes)
                              :content-type "application/json"})))

(defn download-json
  "download a file from S3 - key = path"
  [bucket key]
  (-> (s3/get-object :bucket-name bucket :key key)
      :input-stream
      reader
      (parse-stream true)))
