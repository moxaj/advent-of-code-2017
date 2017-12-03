(ns aoc.day-3b)

(def input 265149)

(defn move [[x y] [dx dy]]
  [(+ x dx) (+ y dy)])

(defn neightbours [[x y]]
  (for [u [-1 0 1]
        v [-1 0 1]
        :when (not= 0 u v)]
    [(+ x u) (+ y v)]))

(def steps (->> (range)
                (mapcat (fn [n]
                          (let [k (if (odd? n) 1 -1)]
                            (concat (repeat n [k 0])
                                    (repeat n [0 k])))))))

(defn solve [input]
  (loop [grid           {[0 0] 1}
         position       [1 0]
         [step & steps] (rest steps)]
    (let [n (transduce (keep grid) + (neightbours position))]
      (if (< input n)
        n
        (recur (assoc grid position n)
               (move position step)
               steps)))))

(comment
  (solve input))
