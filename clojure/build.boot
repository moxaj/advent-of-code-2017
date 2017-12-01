(merge-env!
  :resource-paths #{"src" "resources"}
  :dependencies   '[[org.clojure/clojure "1.9.0-RC2"]])

(deftask dev
  "Dev task for proto-repl."
  []
  (merge-env! :init-ns        'user
              :dependencies   '[[org.clojure/tools.namespace "0.2.11"]
                                [proto-repl                  "0.3.1" :exclusions [org.clojure/core.async]]])
  (require 'clojure.tools.namespace.repl)
  (apply (resolve 'clojure.tools.namespace.repl/set-refresh-dirs) (get-env :directories))
  identity)
