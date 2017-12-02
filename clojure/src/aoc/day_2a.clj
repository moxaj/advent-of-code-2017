(ns aoc.day-2a
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input (slurp (io/resource "aoc/day_2.txt")))

(defn input->spreadsheet [input]
  (->> input
       (string/split-lines)
       (map (fn [line]
              (map #(Integer/parseInt %) (string/split line #"\s"))))))

(defn diff [nums]
  (- (apply max nums)
     (apply min nums)))

(defn solve [input]
  (->> input
       (input->spreadsheet)
       (map diff)
       (reduce +)))

(comment
  (solve input))
