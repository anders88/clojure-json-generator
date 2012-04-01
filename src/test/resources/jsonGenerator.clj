(ns jsonGenerator (:use clojure.test))


(with-test
  (defn quoted [n]
    (let [qmark "\""]
    (str qmark n qmark)))
    (is (= "\"Darth Vader\"" (quoted "Darth Vader")))
  )

(with-test
  (defn key-value [keyvalue] 
    (str (quoted (first keyvalue)) " : " (quoted (second keyvalue))))
  (is (= "\"firstName\" : \"Darth\"" (key-value ["firstName" "Darth"]))))

(with-test 
  (defn split-into-pairs [x]
    ((fn [v result]
    (if (empty? v) result
      (recur (-> v rest rest) (into result [[(first v) (second v)]]))
      )) x [])
    )
    (is (= [[1 2] [3 4]] (split-into-pairs [1 2 3 4])))
    (is (= [[1 2] [3 4] [5 6]] (split-into-pairs [1 2 3 4 5 6])))
)

(with-test
  (defn stringyfy-key-values [key-values]
    (map key-value (split-into-pairs key-values))
  )
  (is (= ["\"firstName\" : \"Darth\"" "\"lastName\" : \"Vader\""] (stringyfy-key-values ["firstName" "Darth" "lastName" "Vader"])))
  )
  

(with-test
  (defn key-value-list [key-values]
    (str "{" (reduce str (interpose ", " (stringyfy-key-values key-values))) "}") 
      )
  (is (= "{\"firstName\" : \"Darth\", \"lastName\" : \"Vader\"}" (key-value-list ["firstName" "Darth" "lastName" "Vader"])))
  )

(run-tests)

