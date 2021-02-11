(ns boilerpipe-clj.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as string]
            [boilerpipe-clj.core :refer :all]
            [boilerpipe-clj.extractors :as ext]))

(defonce test-article
         (slurp "./test/boilerpipe_clj/resources/greenspun-test.html"))

(def extractors [ext/default-extractor
                 ext/article-extractor
                 ext/image-extractor
                 ext/article-sentence-extractor])

(deftest get-text-extraction
  (testing "get-text extracts something from an article
            without a provided extractor"
    (let [res (get-text test-article)]
      (is (and
            (not= res "")
            (not= res nil)))))
  (testing "All the available extractors extract something
            from the article"
    (doseq [ext extractors
            :let [res (get-text test-article ext)]]
      (is (and (not= res "")
               (not (nil? res)))))))

(deftest get-images-extraction
  (testing "get-images extracts something from an html
            content without a provided extractor"
    (let [res (get-images "https://www.nytimes.com/2021/02/10/us/politics/trump-senate-impeachment-trial.html")]
      (= (count res) 2)
      (is (and
            (not= res "")
            (not= res nil)))
      (doseq [i res] (string/includes? (.getSrc i) "https://"))
      (doseq [i res] (number? (.getWidth i))))))