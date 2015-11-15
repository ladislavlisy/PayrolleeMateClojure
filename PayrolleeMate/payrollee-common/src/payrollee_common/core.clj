(ns payrollee-common.core)

(defprotocol protocol-equals
  (is_equal [this other]))
(defprotocol protocol-compare
  (is_greater_than [this other])
  (is_less_than [this other]))

