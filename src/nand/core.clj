(ns nand.core)

(defn uuid
  "Retrieve a type 4 (pseudo randomly generated) UUID. The UUID is generated using a cryptographically strong pseudo random number generator." 
  []
  (str (java.util.UUID/randomUUID)))
