(ns jsonGenerator (:use clojure.test))

(def qmark "\"")


(with-test
  (defn key-value [key value] 
    (str qmark key qmark " : " qmark value qmark))
  (is (= "\"firstName\" : \"Darth\"" (key-value "firstName" "Darth"))))

(run-tests)

