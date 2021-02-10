(defproject run.avelino/boilerpipe-clj "0.3.1"
  :description "A simple wrapper around the Boilerpipe library for extracting text from html articles/pages"
  :url "https://avelino.run"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.10.2"]
                 [org.thnetos/cd-client "0.3.4" :exclusions [org.clojure/clojure cheshire]]
                 [net.sourceforge.nekohtml/nekohtml "1.9.15"]
                 [xerces/xercesImpl "2.9.1"]
                 [com.robbypond/boilerpipe "1.2.3"]])
