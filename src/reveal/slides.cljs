(ns reveal.slides
  (:require [clojure.string :as string]))

(defn- section-with-title
  [title & htmls]
  (let [slugged (string/replace title #"\W" "")]
    [:section {:data-state slugged}
     [:style (str "." slugged " header span:after {content: \"" title "\";}")]
     htmls]))

;; ----------------------------------------------------------------------------

(def slide-1
  [:section {:data-state "footer"}
   [:div#title
    [:h3
     [:img {:style "height: 3em;" :src "img/clojure_logo.svg"}]
     [:br]
     "Clojure: Von Null zu FizzBuzz"]
    [:hr]
    [:p {:style "font-size: 0.8em"}
     [:strong "Christian Meter"]]
    [:small
     "Institut für Informatik" [:br]
     "Heinrich-Heine-Universität Düsseldorf" [:br]
     "19.02.2020" [:br] [:br]
     "meter@hhu.de" [:br]
     "@cmeter_ / @clojure_dus"]]])

(def slide-clojuredus
  (section-with-title
    "Wer sind wir?"
    [:img {:src "img/logo2019.svg"}]
    [:p
     [:a {:href "http://clojure-duesseldorf.de"}
      "clojure-duesseldorf.de"]]))

(def slide-next
  (section-with-title
    "Was kommt als nächstes?"
    [:p [:strong "Lightning Talks"] [:br]
     "am 26.03.2020"]

    [:div.row
     [:div.col-6
      [:p "Themenideen:"]
      [:p "👩‍🏫 Data-Science in Clojure"]
      [:p "🕵️‍♂️ Statische Codeanalyse"]
      [:p "🐣 Anfängererfahrungen"]
      [:p "🔥 Scala vs. Clojure"]]
     [:div.col-6
      [:p "Wir suchen noch Speaker!"]
      [:p "Sprecht uns einfach an, wir coachen auch Newcomer 🚀"]
      [:p "Jeder Talk dauert ca. 10 Minuten"]]]))

(def slide-2
  (section-with-title
    "Clojure ist..."
    [:p "funktional"]
    [:p "dynamisch typisiert"]
    [:p "auf der JVM gehostet"]
    [:p "ein Lisp-Dialekt"]))

(def slide-history
  (section-with-title
    "Geschichte von Clojure"
    [:div.row
     [:div.col-4 [:img {:alt "", :src "img/clojure_logo.svg"}]]
     [:div.col-8
      [:p "Öffentliches Release: Okt. 2007"]
      [:p "Aktuelle Version 1.10.1"]
      [:p "Extrem seriöse Entwicklung"]
      [:p "Nicht \"der neuste heiße Scheiß\" "]
      [:p.highlight "Trotzdem nicht langweilig"]]]))

(def slide-usage
  (section-with-title
    "Wo wird Clojure eingesetzt?"
    [:p "web development (81%)"]
    [:p "open source (48%)"]
    [:p "building and delivering commercial services (31%)"]
    [:small
     [:small
      [:a {:href "https://clojure.org/news/2019/02/04/state-of-clojure-2019"}
       "Source: Clojure Developer Survey 2019"]]]))

(def slide-repl
  (section-with-title
    "To the REPL!"
    [:pre [:code ";; Die REPL – ein mächtiges Werkzeug

(loop (print (eval (read))))
 ^     ^      ^     ^
 └─────└──────└─────└───── *REPL*"]]))

(def slide-links
  (section-with-title
    "Aufgaben"
    [:p "Hier geht's weiter:" [:br]
     [:img {:src "img/github.svg"
            :style "height: 1em; vertical-align: middle; padding-right: .25em"}]
     [:a {:href "https://github.com/clojuredus/fizzbuzz-einsteiger"}
      "clojuredus/fizzbuzz-einsteiger"]]
    [:p "Code aus diesem Talk:" [:br]
     [:img {:src "img/github.svg"
            :style "height: 1em; vertical-align: middle; padding-right: .25em"}]
     [:a {:href "https://github.com/n2o/2020-clojure-von-null-zu-fizzbuzz-talk"}
      "n2o/2020-clojure-von-null-zu-fizzbuzz-talk"]]))

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-clojuredus
   slide-next
   slide-2
   slide-history
   slide-usage
   slide-repl
   slide-links])
