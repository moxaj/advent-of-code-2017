(ns aoc.day-1a
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input (slurp (io/resource "aoc/day_1.txt")))

(defn solve [input]
  (let [nums (->> input
                  (string/trim)
                  (mapv #(Integer/parseInt (str %))))
        nums (conj nums (nums 0))]
    (->> nums
         (partition 2 1)
         (filter #(= (first %) (second %)))
         (map first)
         (reduce +))))

(comment
  (solve input))
