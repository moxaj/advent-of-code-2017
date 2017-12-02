(ns aoc.day-2a
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input (slurp (io/resource "aoc/day_2.txt")))

(defn input->spreadsheet [input]
  (->> input
       (string/split-lines)
       (map (fn [line]
              (map #(Integer/parseInt %) (string/split line #"\s"))))))

(defn div [nums]
  (loop [[num & nums] nums]
    (if-not num
      (throw (Exception. "Invalid input!"))
      (or (some (fn [num']
                  (let [[num num'] (sort [num num'])
                        div (/ num' num)]
                    (when (int? div)
                      div)))
                nums)
          (recur nums)))))

(defn solve [input]
  (->> input
       (input->spreadsheet)
       (map div)
       (reduce +)))

(comment
  (solve input))
