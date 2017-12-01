(ns aoc.day-1b
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input (slurp (io/resource "aoc/day_1.txt")))

(defn solve [input]
  (let [nums (->> input
                  (string/trim)
                  (mapv #(Integer/parseInt (str %))))
        [nums-1 nums-2] (split-at (/ (count nums) 2) nums)]
    (->> (map vector nums-1 nums-2)
         (filter #(= (first %) (second %)))
         (map first)
         (reduce +)
         (* 2))))

(comment
  (solve input))
