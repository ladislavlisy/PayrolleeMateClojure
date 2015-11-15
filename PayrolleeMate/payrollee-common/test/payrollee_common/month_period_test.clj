(ns payrollee-common.month-period-test
  (:use midje.sweet)
  (:use payrollee-common.month-period)
  (:import payrollee_common.month_period.month-period))

(facts "about `MonthPeriod`"
  (def test-period-code-jan 201401)
  (def test-period-code-feb 201402)
  (def test-period-code-mar 201403)
  (def test-period-code-apr 201404)
  (def test-period-code-may 201405)
  (def test-period-code-jun 201406)
  (def test-period-code-jul 201407)
  (def test-period-code-aug 201407)
  (def test-period-code-sep 201409)
  (def test-period-code-oct 201410)
  (def test-period-code-nov 201411)
  (def test-period-code-dec 201412)
  (def test-period-code-501 201501)
  (def test-period-code-402 201402)

  (fact "it should Compare_Different_Periods_AsEqual_When_2014_01"
       (let [test-period-one (month-period. test-period-code-jan)
             test-period-two (month-period. test-period-code-jan)]
         (.is_equal test-period-one test-period-two) => true))

  (fact "it should Compare_Different_Periods_AsEqual_When_2014_02"
       (let [test-period-one (month-period. test-period-code-feb)
             test-period-two (month-period. test-period-code-feb)]
         (.equals test-period-one test-period-two) => true))

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
         (month-period-year test-period-one) => 2014
         (month-period-month test-period-one) => 1))

  (fact "it should Return_Periods_Year_And_Month_2014_02"
       (let [test-period-one (month-period. test-period-code-feb)]
         (month-period-year test-period-one) => 2014
         (month-period-month test-period-one) => 2))

  (fact "it should Return_Periods_Days_In_ Month_And_Year"
       (let [test-period-jan (month-period. test-period-code-jan)
             test-period-feb (month-period. test-period-code-feb)
             test-period-mar (month-period. test-period-code-mar)
             test-period-apr (month-period. test-period-code-apr)
             test-period-may (month-period. test-period-code-may)
             test-period-jun (month-period. test-period-code-jun)
             test-period-jul (month-period. test-period-code-jul)
             test-period-aug (month-period. test-period-code-aug)
             test-period-sep (month-period. test-period-code-sep)
             test-period-oct (month-period. test-period-code-oct)
             test-period-nov (month-period. test-period-code-nov)
             test-period-dec (month-period. test-period-code-dec)]
         (days-in-month test-period-jan) => 31
         (days-in-month test-period-feb) => 28
         (days-in-month test-period-mar) => 31
         (days-in-month test-period-apr) => 30
         (days-in-month test-period-may) => 31
         (days-in-month test-period-jun) => 30
         (days-in-month test-period-jul) => 31
         (days-in-month test-period-aug) => 31
         (days-in-month test-period-sep) => 30
         (days-in-month test-period-oct) => 31
         (days-in-month test-period-nov) => 30
         (days-in-month test-period-dec) => 31))

  (fact "it should Return_Periods_Month_And_Year_Descriptions"
       (let [test-period-jan (month-period. test-period-code-jan)
             test-period-feb (month-period. test-period-code-feb)
             test-period-501 (month-period. test-period-code-501)
             test-period-402 (month-period. test-period-code-402)]
         (month-period-description test-period-jan) => "January 2014"
         (month-period-description test-period-feb) => "February 2014"
         (month-period-description test-period-501) => "January 2015"
         (month-period-description test-period-402) => "February 2014")))

