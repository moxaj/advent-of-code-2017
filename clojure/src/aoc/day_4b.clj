(ns aoc.day-4a
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input (slurp (io/resource "aoc/day_4.txt")))

(defn solve [input]
  (->> input
       (string/split-lines)
       (filter (fn [line]
                 (let [words (map sort (string/split line #"\s"))]
                   (= (count words) (count (set words))))))
       (count)))

(comment
  (solve input))
