(defproject com.novemberain/validateur "2.0.0-beta3-SNAPSHOT"
  :description "Functional validations inspired by Ruby's ActiveModel"
  :license { :name "Eclipse Public License" }
  :url "http://clojurevalidations.info"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure  "1.5.1"]]
  :jar-exclusions [#"\.cljx"]
  :profiles {:1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0-beta1"]]}
             :master {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}
             :dev {:dependencies [[org.clojure/clojurescript "0.0-2138"]]
                   :plugins [[codox "0.6.4"]
                             [com.keminglabs/cljx "0.3.2"]
                             [lein-cljsbuild "1.0.1"]
                             [com.cemerick/clojurescript.test "0.2.1"]]
                   :cljx {:builds [{:source-paths ["src/cljx"]
                                    :output-path "target/classes"
                                    :rules :clj}
                                   {:source-paths ["src/cljx"]
                                    :output-path "target/classes"
                                    :rules :cljs}
                                   {:source-paths ["test"]
                                    :output-path "target/test-classes"
                                    :rules :clj}
                                   {:source-paths ["test"]
                                    :output-path "target/test-classes"
                                    :rules :cljs}]}
                   :cljsbuild {:crossovers [clojurewerkz.support.core]
                               :test-commands {"phantom" ["phantomjs" :runner "target/testable.js"]}
                               :builds [{:source-paths ["target/classes" "target/test-classes"]
                                         :compiler {:output-to "target/testable.js"
                                                    :libs [""]
                                                    :source-map "target/testable.js.map"
                                                    :optimizations :advanced}}]}
                   :codox {:sources ["src/cljx"]
                           :output-dir "doc/api"}}}
  :aliases  {"all" ["with-profile" "+dev:+1.4:+1.6:+master"]}
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :source-paths ["src/cljx" "target/classes"]
  :test-paths ["target/test-classes"]
  :test-selectors {:focus :focus}
  :codox {:only [validateur.validation]})
