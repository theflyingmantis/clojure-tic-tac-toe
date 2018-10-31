(ns first-time.core-test
  (:require [clojure.test :refer :all]
            [first-time.core :refer :all]))

(
  deftest board
  (testing "initial board state is set empty"
           (is (= (get-board) {} ))
           )
  (testing "get position return x,y position of board to 0 to 9 numbered position"
           (is (= (get-position 2 2) 8))
           )
  )
