(ns payrollee-common.month-period
  (:import [java.util Locale])
  (require [clj-time.core :as t])
  (require [clj-time.format :as f]))

  (defprotocol protocol-equals
    (is_equal [this other]))
  (defprotocol protocol-compare
    (is_greater_than [this other])
    (is_less_than [this other]))

  (defrecord month-period [code]
    protocol-equals
    (is_equal [this other]
      (= (:code this) (:code other)))
    protocol-compare
    (is_greater_than [this other]
      (> (:code this) (:code other)))
    (is_less_than [this other]
      (< (:code this) (:code other))))

  (defn period-year [period]
    (quot (:code period) 100))
  (defn period-month [period]
    (mod (:code period) 100))
  (defn begin-of-month [period]
    (t/date-time (period-year period) (period-month period) 1 0 0 0 0))
  (defn period-description [period]
    (let [first-period-day (begin-of-month period)
          custom-formatter (f/with-locale (f/formatter "MMMM yyyy") (Locale/ENGLISH))]
      (f/unparse custom-formatter first-period-day)))