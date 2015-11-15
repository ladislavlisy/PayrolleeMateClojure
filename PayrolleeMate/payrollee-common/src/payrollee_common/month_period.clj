(ns payrollee-common.month-period
  (:use [payrollee-common.core])
  (require [clj-time.core :as t])
  (require [clj-time.format :as f])
  (:import [java.util Locale])
  (:import [java.time YearMonth]))

(defrecord month-period [code]
  Comparable
  (compareTo [this other]
    (- (:code this) (:code other)))
  protocol-equals
  (is_equal [this other]
    (= (:code this) (:code other)))
  protocol-compare
  (is_greater_than [this other]
    (> (:code this) (:code other)))
  (is_less_than [this other]
    (< (:code this) (:code other))))

(defn month-period-year [period]
  (quot (:code period) 100))
(defn month-period-month [period]
  (mod (:code period) 100))
(defn days-in-month [period]
  (.lengthOfMonth (YearMonth/of (month-period-year period) (month-period-month period))))
(defn begin-of-month [period]
  (t/date-time (month-period-year period) (month-period-month period) 1 0 0 0 0))
(defn end-of-month [period]
  (t/date-time (month-period-year period) (month-period-month period) (days-in-month period) 0 0 0 0))
(defn month-period-description [period]
  (let [first-period-day (begin-of-month period)
        custom-formatter (f/with-locale (f/formatter "MMMM yyyy") (Locale/ENGLISH))]
    (f/unparse custom-formatter first-period-day)))