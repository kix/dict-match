(defproject clj-test-task "0.1.0"
  :description "Dictionary attacker"
  :url "https://github.com/kix/dict-match"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.async "1.3.610"]]
  :profiles {:dev {:dependencies [[proto-repl "0.3.1"]
                                  [criterium "0.4.6"]]}}
  :repl-options {:init-ns clj-test-task.core}
  :main clj-test-task.core)
