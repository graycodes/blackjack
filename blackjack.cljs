(ns cljsfiddle)

;; Use the IFrame to the right
;(set! (.-innerHTML (.getElementById js/document "msg"))
;      "Hello, CLJSFiddle!")

(def suits #{:hearts :spades :clubs :diamonds})

(defn createCard
  [num]
  (hash-map :val (if (> num 10) 10 num);; TODO- Aces
            :name (cond
                   (= num 1)  "Ace"
                   (= num 11) "Jack"
                   (= num 12) "Queen"
                   (= num 13) "King"
                   :else      num)
            :visible false))

(def suit (map createCard (range 1 14)))

(defn createSuit [suitName]
  (map #(merge {:suit suitName} %) suit))

(def deck (shuffle (mapcat createSuit suits)))

(defn printCard [card]
  "prints out the card, nicely"
  (println (str "The " (:name card) " of " (name (:suit card)))))

(map printCard deck)

;(dorun 
; (print deck)
; (print "rar"))

(defprotocol Player
  (hit [c])
  (stick [c]))



(defrecord HumanPlayer []
    Player
    (hit [_] (print "hit me!"))
    (stick [_] (print "fuck it")))

(def you (->HumanPlayer)) ;;aww yeah

(hit you) ;; huehuehue

(def player you)

(hit player)

;; Deck
;; - Suits
;; | - Card
;;   | - value, name, visibility, suit
;; - Shuffled

;; Player
;; - Stick



