(ns first-time.core-test
  (:require [clojure.test :refer :all]
            [first-time.core :refer :all]))

(
  deftest board-core
  (testing "initial board state is set empty"
           (is (= (get-board) {} ))
           )
  (testing "get position return x,y position of board to 0 to 9 numbered position"
           (is (= (get-position 2 2) 8))
           )
  )

(
  deftest set-board
  (testing "set state sets the state of the board for star"
           (set-state 2 2 :*)
           (is (= (get-board) {:8 :*})))

  (testing "set state sets the state of the board for circle"
           (set-state 1 1 :o)
           (is (= (get-board) {:4 :o, :8 :*})))
  )
