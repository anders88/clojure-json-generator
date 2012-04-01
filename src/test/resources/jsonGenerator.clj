(ns jsonGenerator)

(defn quoted [n]
    (let [qmark "\""]
    (str qmark n qmark)))

(defn split-into-pairs [x]
    ((fn [v result]
    (if (empty? v) result
      (recur (-> v rest rest) (into result [[(first v) (second v)]]))
      )) x [])
 )   

(defn key-value-list [key-values]
    (let [key-value 
          (fn [keyvalue]  
            (str (quoted 
                   (first keyvalue)) 
                 " : " 
                 (if (vector? (second keyvalue)) (key-value-list (second keyvalue)) (quoted (second keyvalue)))))
          ]
    (let [stringyfy-key-values (fn [key-values] (map key-value (split-into-pairs key-values)))]
    (str "{" (reduce str (interpose ", " (stringyfy-key-values key-values))) "}") 
      )
    ))

(defn string-to-vector [x]
    (let [deep-str (fn ! [s] 
                     (if (vector? s) 
                       (vec (map ! s))
                       (str s)))
          ]
  (vec (map deep-str (eval (read-string x)))))
  )

(defn to-json [code]
    (key-value-list (string-to-vector code))
    )
  