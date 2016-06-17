(ns nand.numeric)

(defn round2
  "Round a double to the given precision (number of significant digits).
  If precision is false, returns original value
  TODO: make multi-arity instead of setting precision false!"
  [precision d]
  (cond
    (nil? d) nil
    (not precision) d
    (<= precision 0) (int (Math/round (float d)))
    :else (let [factor (Math/pow 10 precision)]
            (/ (Math/round (* d factor)) factor))))
