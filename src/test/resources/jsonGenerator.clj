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

(run-tests)

