(ns jsonGenerator (:use clojure.test))


(with-test
  (defn quoted [n]
    (let [qmark "\""]
    (str qmark n qmark)))
    (is (= "\"Darth Vader\"" (quoted "Darth Vader")))
  )

(with-test
  (defn key-value [key value] 
    (str (quoted key) " : " (quoted value)))
  (is (= "\"firstName\" : \"Darth\"" (key-value "firstName" "Darth"))))

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

; Not ready for this yet...
;(with-test
;  (defn key-value-list [key-values]
;  "3")
;  (is (= "{ \"firstName\" : \"Darth\", \"lastName\" : \"Vader\" }" (key-value-list ["firstname" "Darth" "lastname" "Vader"])))
;  )

(run-tests)

