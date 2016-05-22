(ns dgellow.tl-api-client.core
  (:require [clojure.data.json :as json]))

(def default-base-url "https://tl.remembr.moe/api/v1")

(defn make-url
  ([params] (make-url default-base-url params))
  ([base-url params]
   (clojure.string/join
    "/"
    (flatten [default-base-url (map name params)]))))

(defn fetch-url [url]
  (json/read-str (slurp url)))

(defn fetch-lines []
  (fetch-url (make-url [:lines])))

(defn fetch-line [line-id-or-name]
  (fetch-url (make-url [:lines line-id-or-name])))

(defn fetch-directions [line-id-or-name]
  (fetch-url (make-url [:lines line-id-or-name :directions])))

(defn fetch-stations [line-id-or-name direction-id]
  (fetch-url (make-url [:lines line-id-or-name
                        :directions direction-id
                        :stations])))
(defn fetch-horaire [line-id direction-id station-id]
  (fetch-url (make-url [:lines line-id
                        :directions direction-id
                        :stations station-id
                        :horaire])))
