(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/data.json "0.2.6"]
                 [adzerk/bootlaces "0.1.13"]
                 [org.clojure/clojure "1.8.0"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "1.0.0")

(bootlaces! +version+)

(task-options!
 pom {:project 'dgellow/tl-api-client
      :version +version+
      :description "Web client for the unofficial TL Live API (https://tl.remembr.moe)"
      :url "https://github.com/dgellow/tl-api-client"
      :scm {:url "https://github.com/dgellow/tl-api-client"}
      :license {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build project"
  []
  (comp (pom)
        (jar)))
