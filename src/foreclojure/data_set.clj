(ns foreclojure.data-set
  (:use [somnium.congomongo]))

(defn load-problems []
  (do
    (mongo! :db :mydb)
    (insert! :problems
	     {:_id 1
	      :title "Nothing but the Truth"
	      :times-solved 0
	      :description "This is a clojure form.  Enter a value which will make the form evaluate to true.  Don't over think it!  If you are confused, see the <a href='/directions'>getting started</a> page."
	      :tags ["elementary"]
	      :tests ["(= __ true)"]})
    
    (insert! :problems
	     {:_id 2
	      :title "Simple Math"
	      :times-solved 0
	      :description "If you are not familiar with <a href='http://en.wikipedia.org/wiki/Polish_notation'>polish notation</a>, simple arithmetic might seem confusing."
	      :tags ["elementary"]
	      :tests ["(= (- 10 (* 2 3)) __)"]})
    
    (insert! :problems
	     {:_id 3
	      :title "Intro to Strings"
	      :times-solved 0
	      :description "Clojure strings are Java strings.  This means that you can use any of the Java string methods on Clojure strings."
	      :tags["elementary"]
	      :tests ["(= __ (.toUpperCase \"hello world\"))"]})
    
    
    (insert! :problems
	     {:_id 4
	      :title "Intro to Lists"
	      :times-solved 0
	      :description "Lists can be constructed with either a function or a quoted form."
	      :tags["elementary"]
	      :tests ["(= (list __) '(:a :b :c))"]})
  
    (insert! :problems
	     {:_id 5
	      :title "Lists: conj"
	      :times-solved 0
	      :description "When operating on a list, the conj function will return a new list with one or more items \"added\" to the front."
	      :tags["elementary"]
	      :tests ["(= __ (conj '(2 3 4) 1))"
		      "(= __ (conj '(3 4) 2 1))"]})
    
    (insert! :problems
	     {:_id 6
	      :title "Intro to Vectors"
	      :times-solved 0
	      :description "Vectors can be constructed several ways.  You can compare them with lists."
	      :tags["elementary"]
	      :tests ["(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))"]})
    
    (insert! :problems
	     {:_id 7
	      :title "Vectors: conj"
	      :times-solved 0
	      :description "When operating on a Vector, the conj function will return a new vector with one or more items \"added\" to the end."
	      :tags["elementary"]
	      :tests ["(= __ (conj [1 2 3] 4))"
		      "(= __ (conj [1 2] 3 4))"]})
  
    
    (insert! :problems
	     {:_id 8
	      :title "Intro to Sets"
	      :times-solved 0
	      :description "Sets are collections of unique values."
	      :tags["elementary"]
	      :tests ["(= __ (set '(:a :a :b :c :c :c :c :d :d)))"
		      "(= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))"]})
    
    (insert! :problems
	     {:_id 9
	      :title "Sets: conj"
	      :times-solved 0
	      :description "When operating on a set, the conj function returns a new set with one or more keys \"added\"."
	      :tags["elementary"]
	      :tests ["(= #{1 2 3 4} (conj #{1 4 3} __))"]})
    
    
    (insert! :problems
           {:_id 10
            :title "Intro to Maps"
            :times-solved 0
            :description "Maps store key-value pairs.  Both maps and keywords can be used as lookup functions. Commas can be used to make maps more readable, but they are not required."
            :tags["elementary"]
            :tests ["(= __ ((hash-map :a 10, :b 20, :c 30) :b))"
                    "(= __ (:b {:a 10, :b 20, :c 30}))"]})
    
    (insert! :problems
	     {:_id 11
	      :title "Maps: conj"
	      :times-solved 0
	      :description "When operating on a map, the conj function returns a new map with one or more key-value pairs \"added\"."
	      :tags["elementary"]
	      :tests ["(= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))"]})
    
    (insert! :problems
	     {:_id 12
	      :title "Intro to Sequences"
	      :times-solved 0
	      :description "All Clojure collections support sequencing.  You can operate on sequences with functions like first, second, and last."
	      :tags["elementary"]
	      :tests ["(= __ (first '(3 2 1)))"
		      "(= __ (second [2 3 4]))"
		      "(= __ (last (list 1 2 3)))"]})
    
    (insert! :problems
	     {:_id 13
	      :title "Sequences: rest"
	      :times-solved 0
	      :description "The rest function will return all the items of a sequence except the first."
	      :tags["elementary"]
	      :tests ["(= __ (rest [10 20 30 40]))"]})
    
    (insert! :problems
	     {:_id 14
	      :title "Intro to Functions"
	      :times-solved 0
	      :description "Clojure has many different ways to create functions."
	      :tags["elementary"]
	      :tests ["(= __ ((fn add-five [x] (+ x 5)) 3))"
		      "(= __ ((fn [x] (+ x 5)) 3))"
		      "(= __ (#(+ % 5) 3))"
		      "(= __ ((partial + 5) 3))"]})
  
    (insert! :problems
           {:_id 15
            :title "Double Down"
            :times-solved 0
            :description "Write a function which doubles a number."
            :tags ["elementary"]
            :tests ["(= (__ 2) 4)"
                    "(= (__ 3) 6)"]
            :secret-tests ["(= (__ 11) 22)"
                           "(= (__ 7) 14)"]})
    
    (insert! :problems
	     {:_id 16
	      :title "Hello World"
	      :times-solved 0
	      :description "Write a function which returns a personalized greeting."
	      
	      :tags ["elementary"]
	      :tests ["(= (__ \"Dave\") \"Hello, Dave!\")"
		      "(= (__ \"Jenn\") \"Hello, Jenn!\")"]
	      :secret-tests ["(= (__ \"Rhea\") \"Hello, Rhea!\")"]})
    
    (insert! :problems
	     {:_id 17
	      :title "Sequences: map"
	      :times-solved 0
	      :description "The map function takes two arguments: a function (f) and a sequence (s).  Map returns a new sequence consisting of the result of applying f to each item of s.  Do not confuse the map function with the map data structure."
	      :tags["elementary"]
	      :tests ["(= __ (map #(+ % 5) '(1 2 3)))"]})
    
    (insert! :problems
	     {:_id 18
	      :title "Sequences: filter"
	      :times-solved 0
	      :description "The filter function takes two arguments: a predicate function (f) and a sequence (s).  Filter returns a new sequence consisting of all the items of s for which (f item) returns true."
	      :tags["elementary"]
	      :tests ["(= __ (filter #(> % 5) '(3 4 5 6 7)))"]})
    
    (insert! :problems
	     {:_id 19
	      :title "Last Element"
	      :times-solved 0
	      :restricted ["last"]
	      :description "Write a function which returns the last element in a sequence."
	      :tags ["easy" "seqs" "core-functions"]
	      :tests ["(= (__ [1 2 3 4 5]) 5)"
		      "(= (__ '(5 4 3)) 3)"]
	      :secret-tests ["(= (__ [\"b\" \"c\" \"d\"]) \"d\")"]})
    
    (insert! :problems
             {:_id 20
              :title "Penultimate Element"
              :times-solved 0
              :description "Write a function which returns the second to last element from a sequence."
              :tags["easy" "seqs"]
              :tests ["(= (__ (list 1 2 3 4 5)) 4)"
                      "(= (__ [\"a\" \"b\" \"c\"]) \"b\")"]
              :secret-tests ["(= (__ [[1 2] [3 4]]) [1 2])"]})
    
    (insert! :problems
	     {:_id 21
	      :title "Nth Element"
	      :times-solved 0
	      :restricted ["nth"]
	      :description "Write a function which returns the Nth element from a sequence."
	      :tags["easy" "seqs" "core-functions"]
	      :tests ["(= (__ '(4 5 6 7) 2) 6)"
		      "(= (__ [:a :b :c] 0) :a)"
		      "(= (__ [1 2 3 4] 1) 2)"]
	      :secret-tests ["(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])"]})
    
    (insert! :problems
	     {:_id 22
	      :title "Count a Sequence"
	      :times-solved 0
	      :restricted ["count"]
	      :description "Write a function which returns the total number of elements in a sequence."
	      :tags["easy" "seqs" "core-functions"]
	      :tests ["(= (__ '(1 2 3 3 1)) 5)"
		      "(= (__ \"Hello World\") 11)"
		      "(= (__ [[1 2] [3 4] [5 6]]) 3)"]
	      :secret-tests ["(= (__ '(13)) 1)"
			     "(= (__ '(:a :b :c)) 3)"]})
    
    (insert! :problems
	     {:_id 23
	      :title "Reverse a Sequence"
	      :times-solved 0
	      :restricted ["reverse"]
	      :description "Write a function which reverses a sequence."
	      :tags["easy" "seqs" "core-functions"]
	      :tests ["(= (__ [1 2 3 4 5]) [5 4 3 2 1])"
		      "(= (__ (sorted-set 5 7 2 7)) '(7 5 2))"]
	      :secret-tests ["(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])"]})
    
    (insert! :problems
	     {:_id 24
	      :title "Sum It All Up"
	      :times-solved 0
	      :description "Write a function which returns the sum of a sequence of numbers."
	      :tags ["easy" "seqs"]
	      :tests ["(= (__ [1 2 3]) 6)"
		      "(= (__ (list 0 -2 5 5)) 8)"
		      "(= (__ #{4 2 1}) 7)"]
	      :secret-tests ["(= (__ '(0 0 -1)) -1)"
			     "(= (__ '(1 10 3)) 14)"]})
    
    (insert! :problems
	     {:_id 25
	      :title "Find the odd numbers"
	      :times-solved 0
	      :description "Write a function which returns only the odd numbers from a sequence."
	      :tags["easy" "seqs"]
	      :tests ["(= (__ #{1 2 3 4 5}) '(1 3 5))"
		      "(= (__ [4 2 1 6]) '(1))"]
	      :secret-tests ["(= (__ [2 2 4 6]) '())"
			     "(= (__ [1 1 1 3]) '(1 1 1 3))"]})
    
    (insert! :problems
	     {:_id 26
	      :title "Fibonacci Sequence"
	      :times-solved 0
	      :description "Write a function which returns the first X fibonacci numbers."
	      :tags["easy" "Fibonacci" "seqs"]
	      :tests ["(= (__ 3) '(1 1 2))"
		      "(= (__ 6) '(1 1 2 3 5 8))"]
	      :secret-tests ["(= (__ 8) '(1 1 2 3 5 8 13 21))"]})
    
    (insert! :problems
	     {:_id 27
	      :title "Palindrome Detector"
	      :times-solved 0
	      :description "Write a function which returns true if the given sequence is a palindrome.<br/><br>
                Hint: \"racecar\" does not equal '(\\r \\a \\c \\e \\c \\a \\r)"
	      :tags["easy" "seqs"]
	      :tests ["(false? (__ '(1 2 3 4 5)))"
		      "(true? (__ \"racecar\"))"
		      "(true? (__ [:foo :bar :foo]))"]
	      :secret-tests ["(true? (__ '(1 1 3 3 1 1)))"
			     "(false? (__ '(:a :b :c)))"]})
    
    (insert! :problems
	     {:_id 28
	      :title "Flatten a Sequence"
	      :times-solved 0
	      :restricted ["flatten"]
	      :description "Write a function which flattens a sequence."
	      
	      :tags["easy" "seqs" "core-functions"]
	      :tests ["(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))"
		      "(= (__ [\"a\" [\"b\"] \"c\"]) '(\"a\" \"b\" \"c\"))"]
	      :secret-tests ["(= (__ '((((:a))))) '(:a))"]})
    
    (insert! :problems
	     {:_id 29
	      :title "Get the Caps"
	      :times-solved 0
	      :description "Write a function which takes a string and returns a new string containing only the capital letters."
	      :tags["easy" "strings"]
	      :tests ["(= (__ \"HeLlO, WoRlD!\") \"HLOWRD\")"
		      "(empty? (__ \"nothing\"))"]
	      :secret-tests ["(= (__ \"$#A(*&987Zf\") \"AZ\")"]})
    
    (insert! :problems
	     {:_id 30
	      :title "Compress a Sequence"
	      :times-solved 0
	      :description "Write a function which removes consecutive duplicates from a sequence."
	      :tags ["easy" "seqs"]
	      :tests ["(= (apply str (__ \"Leeeeeerrroyyy\")) \"Leroy\")"
		      "(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))"]
	      :secret-tests ["(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))"]})
    
    (insert! :problems
	     {:_id 31
	      :title "Pack a Sequence"
	      :times-solved 0
	      :description "Write a function which packs consecutive duplicates into sub-lists."
	      :tags ["easy" "seqs"]
	      :tests ["(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))"
		      "(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))"]
	      :secret-tests ["(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))"]})
    
    (insert! :problems
	     {:_id 32
	      :title "Duplicate a Sequence"
	      :times-solved 0
	      :description "Write a function which duplicates each element of a sequence."
	      :tags ["easy" "seqs"]
	      :tests ["(= (__ [1 2 3]) '(1 1 2 2 3 3))"
		      "(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))"]
	      :secret-tests ["(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))"]})
    
    (insert! :problems
	     {:_id 33
	      :title "Replicate a Sequence"
	      :times-solved 0
	      :description "Write a function which replicates each element of a sequence a variable number of times."
	      :tags ["easy" "seqs"]
	      :tests ["(= (__ [1 2 3] 2) '(1 1 2 2 3 3))"
		      "(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
                     (= (__ [4 5 6] 1) '(4 5 6))"]
	      :secret-tests ["(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))"]})
    
    (insert! :problems
	     {:_id 34
	      :title "Implement range"
	      :times-solved 0
	      :restricted ["range"]
	      :description "Write a function which creates a list of all integers in a given range."
	      :tags ["easy" "seqs" "core-functions"]
	      :tests ["(= (__ 1 4) '(1 2 3))"
		      "(= (__ -2 2) '(-2 -1 0 1))"]
	      :secret-tests ["(= (__ 5 8) '(5 6 7))"]})

    (insert! :problems
           {:_id 35
            :title "Local bindings"
            :times-solved 0
            :description "Clojure lets you give local names to values using the special let-form."
            :tags ["elementary" "syntax"]
            :tests ["(= __ (let [x 5] (+ 2 x)))"
		    "(= __ (let [x 3, y 10] (- y x)))"
                    "(= __ (let [x 21] (let [y 3] (/ x y))))"]})

  (insert! :problems
           {:_id 36
            :title "Let it Be"
            :times-solved 0
            :description "Can you bind x, y, and z so that these are all true?"
            :tags ["elementary" "math" "syntax"]
            :tests ["(= 10 (let __ (+ x y)))"
		    "(= 4 (let __ (+ y z)))"
                    "(= 1 (let __ z))"]})))