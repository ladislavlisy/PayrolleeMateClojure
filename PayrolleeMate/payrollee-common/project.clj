(defproject payrollee-common "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-time "0.11.0"]]
  :profiles {
             :dev {
                   :dependencies [[midje "1.8.2"]]
                   :plugins [[lein-midje "3.2"]]}})
