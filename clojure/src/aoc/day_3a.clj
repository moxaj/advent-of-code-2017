(ns aoc.day-3a)

(def input 265149)

(defn distance [x y]
  (+ (Math/abs x) (Math/abs y)))

(defn solve [input]
  ;; Bottom
  (let [n   (int (Math/ceil (Math/sqrt input)))
        n   (cond-> n
              (even? n) inc)
        x   (/ (dec n) 2)
        y   (- x)
        max (* n n)
        min (- max (- n 2))
        n   (dec n)]
    (if (<= min input)
      (distance (- x (- max input)) y)
      ;; Left
      (let [max (- max n)
            min (- min n)
            x   (- x n)]
        (if (<= min input)
          (distance x (+ y (- max input)))
          ;; Top
          (let [max (- max n)
                min (- min n)
                y   (+ y n)]
            (if (<= min input)
              (distance (+ x (- max input)) y)
              ;; Right
              (let [max (- max n)
                    min (- min n)
                    x   (+ x n)]
                (if (<= min input)
                  (distance x (- y (- max input)))
                  (throw (Exception. "Not possible!")))))))))))

(comment
  (solve input))
