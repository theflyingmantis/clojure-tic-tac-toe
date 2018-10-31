(ns first-time.core-test
  (:require [clojure.test :refer :all]
            [first-time.core :refer :all]))

(
  deftest a-test
  (testing "initial board state is set empty"
           (is (= (get-board) {} ))
           )
  )
