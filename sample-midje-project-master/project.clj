(defproject quux "1.0.0"
  :description "A project useful for reporting problems with Midje."
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :profiles {:dev {:dependencies [[midje "1.8.1"]]
                   :plugins [[lein-midje "3.2"]]}})
