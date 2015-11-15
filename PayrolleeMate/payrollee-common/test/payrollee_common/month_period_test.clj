(ns payrollee-common.month-period-test
  (:use midje.sweet)
  (:use payrollee-common.month-period)
  (:import payrollee_common.month_period.month-period))

(facts "about `MonthPeriod`"
  (def test-period-code-jan 201401)
  (def test-period-code-feb 201402)
  (def test-period-code-501 201501)
  (def test-period-code-402 201402)

  (fact "it should Compare_Different_Periods_AsEqual_When_2014_01"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-jan)]
         (.is_equal test-period-one test-period-two) => true))

  (fact "it should Compare_Different_Periods_AsEqual_When_2014_02"
       (let [test-period-one (month-period. test-period-code-feb)
             test-period-two (month-period. test-period-code-feb)]
         (.is_equal test-period-one test-period-two) => true))

  (fact "it should Compare_Different_Periods_SameYear_AsGreater"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-feb)]
         (.is_equal test-period-one test-period-two) => false
         (.is_greater_than test-period-two test-period-one) => true))

  (fact "it should Compare_Different_Periods_SameYear_AsLess"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-feb)]
         (.is_equal test-period-one test-period-two) => false
         (.is_less_than test-period-one test-period-two) => true))

  (fact "it should Compare_Different_Periods_SameMonth_AsGreater"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-feb)]
         (.is_equal test-period-one test-period-two) => false
         (.is_greater_than test-period-two test-period-one) => true))

  (fact "it should Compare_Different_Periods_SameMonth_AsLess"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-feb)]
         (.is_equal test-period-one test-period-two) => false
         (.is_less_than test-period-one test-period-two) => true))

  (fact "it should Compare_Different_Periods_DifferentYear_AsGreater"
       (let [test-period-one (month-period. test-period-code-402)
             test-period-two (month-period. test-period-code-501)]
         (.is_equal test-period-one test-period-two) => false
         (.is_greater_than test-period-two test-period-one) => true))

  (fact "it should Compare_Different_Periods_DifferentYear_AsLess"
       (let [test-period-one (month-period. test-period-code-402)
             test-period-two (month-period. test-period-code-501)]
         (.is_equal test-period-one test-period-two) => false
         (.is_less_than test-period-one test-period-two) => true))

  (fact "it should Return_Periods_Year_And_Month_2014_01"
       (let [test-period-one (month-period. test-period-code-jan)]
         (period-year test-period-one) => 2014
         (period-month test-period-one) => 1))

  (fact "it should Return_Periods_Year_And_Month_2014_02"
       (let [test-period-one (month-period. test-period-code-feb)]
         (period-year test-period-one) => 2014
         (period-month test-period-one) => 2))

  (fact "it should Return_Periods_Month_And_Year_Descriptions"
       (let [test-period-jan (month-period. test-period-code-jan)
             test-period-feb (month-period. test-period-code-feb)
             test-period-501 (month-period. test-period-code-501)
             test-period-402 (month-period. test-period-code-402)]
         (period-description test-period-jan) => "January 2014"
         (period-description test-period-feb) => "February 2014"
         (period-description test-period-501) => "January 2015"
         (period-description test-period-402) => "February 2014")))

