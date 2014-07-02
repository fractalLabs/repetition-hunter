(ns leiningen.hunter
  (:use repetition.hunter
        leiningen.core.eval)
  (:require [bultitude.core :as b]))

(defn hunter
  "Use repetition hunter."
  [project & args]
  (let [los-ns (b/namespaces-on-classpath :classpath (str "src:" (project :name)))]
    (println "namespaces-on-classpath: " los-ns)
    (eval-in-project
      project 
      `(hunt (apply list '~los-ns))
      `(apply require (conj (apply list '~los-ns) '[repetition.hunter :refer :all])))))
