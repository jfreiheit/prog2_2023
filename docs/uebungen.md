# Übungen


##### Übung 1 (Codereview und static)

??? "Was ist an diesem Code alles falsch?"

	```java
	package uebungen.uebung1;

	/*
	 * °C = (°F - 32) * 5/9 (von Fahrenheit in Celsius)
	 * °F = °C * 1,8 + 32 (von Celsius nach Fahrenheit)
	 */

	public class Konvertierung {
		
		private double celsius;
		private double fahrenheit;
		
		public Konvertierung(double celsius) 
		{		
			this.celsius = celsius;
			this.fahrenheit = celsius * 1.8 + 32;		
		}
		
		public Konvertierung(double fahrenheit) 
		{		
			this.celsius = fahrenheit - 32 * 5/9;
			this.fahrenheit = fahrenheit;		
		}
		
		public void print()
		{
			System.out.println(this.celsius + "\u00B0C = " + this.fahrenheit + "\u00B0F");
		}
	}
	```


??? success "Eine mögliche Lösung für Übung 1"
	```java
	package uebungen.uebung1;

	/*
	 * °C = (°F - 32) * 5/9 (von Fahrenheit in Celsius)
	 * °F = °C * 1,8 + 32 (von Celsius nach Fahrenheit)
	 */

	public class Konvertierung {

		private Konvertierung() {
			
		}
	    
	    public static double celsiusToFahrenheit(double celsius) {
	    	final double FACTOR_CELSIUS_TO_FAHRENHEIT = 1.8;
	    	final int DIFFERENCE_CELSIUS_TO_FAHRENHEIT = 32;
	    	
	    	double fahrenheit = celsius * FACTOR_CELSIUS_TO_FAHRENHEIT 
	    			+ DIFFERENCE_CELSIUS_TO_FAHRENHEIT; 
	    	
	    	return fahrenheit;
	    }
	    
	    public static double fahrenheitToCelsius(double fahrenheit) {
	    	final double FACTOR_FAHRENHEIT_TO_CELSIUS = 5.0/9.0;
	    	final int DIFFERENCE_FAHRENHEIT_TO_CELSIUS = 32;
	    	
	    	double celsius = (fahrenheit - DIFFERENCE_FAHRENHEIT_TO_CELSIUS) * FACTOR_FAHRENHEIT_TO_CELSIUS;
	   
	    	return celsius;
	    }
	}
	```

##### Übung 2 (String und algorithmisches Denken)

??? "Übung 2"

	1. Erstellen Sie im Paket `uebungen.uebung2` eine Java-Klasse `Uebung2` mit `main()`-Methode. In diese Klasse implementieren wir statische Methoden. Öffnen Sie zum Lösen der Übung am besten die JavaDoc-Dokumentation der Klasse [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html). Überlegen Sie sich, bevor Sie jeweils anfangen zu implementieren, genau, wie Sie vorgehen möchten.

	2. Implementieren Sie eine Methode `static boolean isBinaryNumber(String s)`. Diese Methode überprüft, ob der `String s` einer Binärzahl entspricht, d.h. ob er nur `0` und `1` enthält. 

	3. Testen Sie die Methode `isBinaryNumber(String s)` z.B. mit den folgenden Aufrufen:
	```java
	System.out.println(isBinaryNumber("101101"));	// true
	System.out.println(isBinaryNumber("0"));		// true
	System.out.println(isBinaryNumber("101a01"));	// false
	System.out.println(isBinaryNumber("101201"));	// false
	```

	4. Implementieren Sie eine Methode `static int binaryToDecimal(String s)`. Diese Methode wandelt den `String s` in eine Dezimalzahl um, wenn `s` einer Binärzahl entspricht. Wenn `s` keiner Binärzahl entspricht, wird `-1` zurückgegeben. 

	5. Testen Sie die Methode `binaryToDecimal(String s)` z.B. mit den folgenden Aufrufen:
	```java
	System.out.println(binaryToDecimal("101101"));	// 45
	System.out.println(binaryToDecimal("0"));		// 0
	System.out.println(binaryToDecimal("000001"));	// 1
	System.out.println(binaryToDecimal("100000"));	// 32
	System.out.println(binaryToDecimal("101a01"));	// -1
	System.out.println(binaryToDecimal("101201"));	// -1
	```

	6. Implementieren Sie eine Methode `static String toLowerCase(String input)`. Diese Methode wandelt alle Großbuchstaben ('A'...'Z') in Kleinbuchstaben um (und nur diese - alle anderen Zeichen bleiben erhalten). Schauen Sie sich dazu auch nochmal die [ASCII-Tabelle](https://freiheit.f4.htw-berlin.de/prog1/variablen/#char) an.

	7. Testen Sie die Methode `toLowerCase(String input)` z.B. mit den folgenden Aufrufen:
	```java
	System.out.println(toLowerCase("abcdEFG"));		// abcdefg
	System.out.println(toLowerCase("abcd123EFG"));	// abcd123efg
	System.out.println(toLowerCase("ABC XYZ !%"));	// abc xyz !%
	```

	**Zusatz:**

	8. Implementieren Sie eine Methode `static boolean isPalindrome(String input)`. Diese Methode prüft, ob es sich bei `input` um ein Palindrom handelt (also von vorne nach hinten genauso gelesen werden kann, wie von hinten nach vorne). Groß- und Kleinschreibung wird nicht berücksichtigt! Die Methode [substring(int,int)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#substring(int,int)) aus `String` ist dabei wahrscheinlich nützlich!

	9. Testen Sie die Methode `isPalindrome(String input)` z.B. mit den folgenden Aufrufen:
	```java
	System.out.println(isPalindrome("Otto"));		// true
	System.out.println(isPalindrome("abc_CBA"));	// true
	System.out.println(isPalindrome("abc_-CBA"));	// false
	System.out.println(isPalindrome("-"));			// true
	System.out.println(isPalindrome("Dreh mal am Herd"));	// false 
	```

	8. Angenommen, Sie sollen für einen gegebenen `String` angeben, ob er korrekt geklammerte Ausdrücke enthält (nur die Klammern betrachten). Wie würden Sie vorgehen? Nicht implementieren, nur nachdenken. Folgende Beispiele:
	```
	((()))()(()) 		// korrekt
	((())				// nicht korrekt
	(()))				// nicht korrekt
	())(				// nicht korrekt
	```

??? success "Eine mögliche Lösung für Übung 2"
	```java
	package uebungen.uebung2.loesung;

	public class Uebung2 {
		
		public static boolean isBinaryNumber(String s)
		{
			for(int index=0; index < s.length(); index++)
			{
				char c = s.charAt(index);
				if(!(c=='0' || c=='1'))
				{
					return false;
				}
			}
			return true;
		}
		
		public static int binaryToDecimal(String s)
		{
			if(!isBinaryNumber(s)) return -1;
			int decimalNumber = 0;
			int exp = 0;
			for(int index = s.length()-1; index >= 0; index--)
			{
				char c = s.charAt(index);
				int digit = c - '0';
				int value = digit * (int)Math.pow(2, exp);
				decimalNumber += value;
				exp++;
			}
			
			return decimalNumber;
		}
		
		public static String toLowerCase(String input)
		{
			String output = "";
			final int UPPER_TO_LOWER = 32;

			for(int index=0; index < input.length(); index++)
			{
				char c = input.charAt(index);
				if(c >= 'A' && c<= 'Z')
				{
					c = (char)(c + UPPER_TO_LOWER);
				}
				output += c;
			}
			return output;
		}
			
		public static boolean isPalindrome(String input)
		{
			String s = toLowerCase(input);
			boolean palindrome = true;
			while(palindrome && s.length() > 1)
			{
				char c1 = s.charAt(0); 
				char c2 = s.charAt(s.length() - 1);
				if(c1 == c2)
				{
					s = s.substring(1,s.length() - 1);
				}
				else 
				{
					palindrome = false;
				}
			}
			return palindrome;
		}
			
		public static boolean checkBraces(String input)
		{
			int nrOpening = 0;	// man koennte auch fuer jede oeffnende ++ und
			int nrClosing = 0;	// jede schliessende -- und dann nur eine Variable
								// dann pruefen, ob nie negativ
			boolean correct = true;
			for(int index=0; correct && index < input.length(); index++)
			{
				char c = input.charAt(index);
				if(c== '(') 
				{
					nrOpening++;
				}
				else if(c== ')') 
				{
					nrClosing++;
				}
				
				if(nrClosing > nrOpening)	// dann waere hier < 0
				{
					correct = false;
				}
			}
			if(nrOpening != nrClosing) 		// dann waere hier == 0
			{
				correct = false;
			}
			return correct;
		}

		public static void main(String[] args) {
			System.out.println(isBinaryNumber("101101"));	// true
			System.out.println(isBinaryNumber("0"));		// true
			System.out.println(isBinaryNumber("101a01"));	// false
			System.out.println(isBinaryNumber("101201"));	// false

			System.out.println(binaryToDecimal("101101"));	// 45
			System.out.println(binaryToDecimal("0"));		// 0
			System.out.println(binaryToDecimal("000001"));	// 1
			System.out.println(binaryToDecimal("100000"));	// 32
			System.out.println(binaryToDecimal("101a01"));	// -1
			System.out.println(binaryToDecimal("101201"));	// -1
			
			System.out.println(toLowerCase("abcdEFG"));		// abcdefg
			System.out.println(toLowerCase("abcd123EFG"));	// abcd123efg
			System.out.println(toLowerCase("ABC XYZ !%"));	// abc xyz !%
		
			System.out.println(isPalindrome("Otto"));		// true
			System.out.println(isPalindrome("abc_CBA"));	// true
			System.out.println(isPalindrome("abc_-CBA"));	// false
			System.out.println(isPalindrome("-"));			// true
			System.out.println(isPalindrome("Dreh mal am Herd"));	// false
			// das letzte waere okay, wenn man bei der Pruefung
			// die Leerzeichen ignorieren wuerde, waere auch moeglich
		}

	}
	```


##### Übung 3 (Exceptions)

??? "Übung 3"

	1. Schreiben Sie ein Programm zur Eingabe von zwei Zahlen mithilfe der Klasse `JOptionPane` und deren Division! Fangen Sie folgende Ausnahmen ab:
		- Falls die Eingabe keiner Zahl entspricht.
		- Falls die zweite Zahl eine 0 ist.

	2. **Scenario**:
		- Fenster zur Eingabe von Zahl 1 öffnet sich: <br/>
			![uebung2](./files/22_uebung2.png)
		- falsche Eingabe - keine Zahl:  <br/>
			![uebung2](./files/23_uebung2.png)
		- Fenster öffnet sich erneut (andere Nachricht!):  <br/>
			![uebung2](./files/24_uebung2.png)
		- Fenster zur Eingabe von Zahl 2 öffnet sich:  <br/>
			![uebung2](./files/25_uebung2.png)
		- die Division Zahl1/Zahl2 schlägt fehl (`ArithmeticException`), deshalb (andere Nachricht!):  <br/>
			![uebung2](./files/26_uebung2.png)
		- Ergebnis  <br/>
			![uebung2](./files/27_uebung2.png)

	3. Lagern Sie eine solche Eingabemöglichkeit in eine wiederverwendbare Methode aus, z.B. `public int inputInt(int min, int max)`, welche die eingegebene Zahl zurückgibt, wobei die eingegebene Zahl im Bereich `[min, max]` liegen muss.

	4. Lesen Sie eine Zahl ein und geben Sie die Zahl umgedreht (rückwärts gelesen) wieder aus (führende Nullen entfallen):
		```bash
		3456789 --> 9876543
		```

		```bash
		1000 --> 1
		```

	5. Lesen Sie eine Zahl ein und geben Sie die Quersumme der Zahl aus.

		```bash
		123456 --> 21
		```

		```bash
		1000 --> 1		
		```

	**Viel Spaß!**


??? success "Eine mögliche Lösung für Übung 3"
	```java
	package uebungen.uebung3.loesung;

	import javax.swing.JOptionPane;

	public class Uebung3 
	{
		public static int inputInt(String message)
		{
			int number = 0;
			boolean notANumber = true;
			while(notANumber)
			{
				String input = JOptionPane.showInputDialog(message);
		
				try 
				{
					number = Integer.parseInt(input);
					notANumber = false;
				} 
				catch (NumberFormatException e) 
				{
					message = "Ihre Eingabe war keine Zahl!";
				}
			}
			return number;
		}
		
		public static int inputInt(String message, int min, int max)
		{
			int number = 0;
			boolean notANumber = true;
			while(notANumber)
			{
				String input = JOptionPane.showInputDialog(message);
		
				try 
				{
					number = Integer.parseInt(input);
					if(number >= min && number <= max)
					{
						notANumber = false;
					}
					else
					{
						message = "Zahl nicht zwischen " + min + " und " + max +" !";
					}
				} 
				catch (NumberFormatException e) 
				{
					message = "Ihre Eingabe war keine Zahl!";
				}
			}
			return number;
		}
		
		public static void printDivide()
		{
			int number1 = inputInt("Zahl 1:");
			int number2 = 0;
			double result = 0.0;
			
			boolean isZero = true;
			String message = "Zahl 2:";
			
			while(isZero)
			{
				number2 = inputInt(message);
		
				try 
				{
					result = number1 / number2;
					isZero = false;
				} 
				catch (ArithmeticException e) 
				{
					message = "Zahl darf nicht 0 sein";
				}
			}
			String output = number1 + " / " + number2 + " = " + result;
			
			JOptionPane.showMessageDialog(null, output);
		}
		
		public static void printReverse()
		{
			int number = inputInt("Zahl : ");
			int copyNumber = number;		// fuer spaetere Ausgabe
			int reverse = 0;
			
			while(number != 0)
			{
				int last = number % 10; 
				reverse = reverse * 10 + last;
				number = number / 10;	
			}
			
			String output = copyNumber + " --> " + reverse;
			JOptionPane.showMessageDialog(null, output); 
		}
		
		
		public static void printChecksum()
		{
			int number = inputInt("Zahl : ");
			int copyNumber = number;		// fuer spaetere Ausgabe
			int checksum = 0;
			
			while(number != 0)
			{
				int last = number % 10; 
				checksum = checksum + last;
				number = number / 10;	
			}
			
			String output = "Die Quersumme von " + copyNumber + " ist " + checksum;
			JOptionPane.showMessageDialog(null, output); 
		}

		public static void main(String[] args) 
		{
			
			  int number1 = inputInt("Geben Sie eine Zahl ein :");
			  System.out.println(number1);

			  int choice = JOptionPane.showConfirmDialog(null, "Wollen Sie weiterspielen?",
			  "Abfrage", JOptionPane.YES_NO_OPTION); 
			  System.out.println(choice);
			  
			  if(choice == JOptionPane.YES_OPTION) 
			  { 
				  System.out.println("yes geklickt"); 
			  }
			  if(choice == JOptionPane.NO_OPTION) 
			  { 
				  System.out.println("no geklickt"); 
			  }
			  if(choice == JOptionPane.CANCEL_OPTION) 
			  { 
				  System.out.println("no geklickt");
			  }
			 
			  printDivide();
			
			  printReverse();
			  
			  printChecksum();

		}

	}
	```


##### Übung 4 (Listen und Mengen)

??? "Übung 4"

	1. Erstellen Sie eine Klasse `Uebung4` mit `main()`-Methode.
	2. Definieren Sie in der `main()`-Methode eine Variable `words` vom Typ `String[]` und weisen Sie dieser Variablen folgende Werte zu:
		```java
		String[] words = {"Linux", "Apple", "Facebook", "Amazon", "IBM", "Lenovo", "Google", "IBM", "Microsoft", "Apple", "Google", "Twitter", "Skype", "Chrome", "Linux", "Firefox"};
		```

	**A. Listen (`List`)**

	1. Erstellen Sie eine Methode `public static List<String> createArrayList(String[] words)`. In dieser Methode soll eine `ArrayList` erstellt werden. Alle Elemente in dieser Liste sind vom Typ `String`. Befüllen Sie diese Liste mit allen Wörtern aus dem `words`-Array. Die Methode gibt die befüllte Liste (`List`) zurück. 
	2. Erstellen Sie eine Methode `public static void printList(List<String> list)`. Diese Methode gibt alle Elemente der Liste `list` auf der Konsole aus. Geben Sie auch die Anzahl der Elemente der Liste aus. 
	3. Erstellen Sie in der `main()`-Methode mithilfe der Methode `createArrayList(words)` eine Liste und speichern Sie diese Liste in einer Variablen vom Typ `List<String>`. Geben Sie alle Elemente dieser Liste mithilfe der Methode `printList()` auf der Konsole aus. 
	4. Studieren Sie alle Methoden für `List` unter [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html).

		- Ermitteln Sie den Index in der Liste, in der `"Apple"` das **erste** Mal auftaucht. Erzeugen Sie folgende Ausgabe: 
			```bash
			Index des ersten Auftretens von Apple  : 1
			```

		- Ermitteln Sie den Index in der Liste, in der `"Apple"` das **letzte** Mal auftaucht. Erzeugen Sie folgende Ausgabe: 
			```bash
			Index des letzten Auftretens von Apple : 9
			```

		- Geben Sie den Wert des **ersten** Elementes der Liste aus. Erzeugen Sie folgende Ausgabe: 
			```bash
			erstes Element der Liste : Linux
			```	

		- Geben Sie den Wert des **letzten** Elementes der Liste aus. Erzeugen Sie folgende Ausgabe: 
			```bash
			letztes Element der Liste : Firefox
			```	

		- Löschen Sie die Werte `"Apple"`, `"Google"` und `"Facebook"`. Geben Sie die Liste erneut mithilfe der `printList(list)`-Methode aus.

	**B. Mengen (`Set`)**

	1. Erstellen Sie eine Methode `public static Set<String> createHashSet(String[] words)`. In dieser Methode soll eine `HashSet` erstellt werden. Alle Elemente in dieser Liste sind vom Typ `String`. Befüllen Sie diese Liste mit allen Wörtern aus dem `words`-Array. Die Methode gibt die befüllte Menge (`Set`) zurück. 
	2. Erstellen Sie eine Methode `public static void printSet(Set<String> set)`. Diese Methode gibt alle Elemente der Menge `set` auf der Konsole aus. Geben Sie auch die Anzahl der Elemente der Menge aus. 
	3. Erstellen Sie in der `main()`-Methode mithilfe der Methode `createHashSet(words)` eine Menge und speichern Sie diese Menge in einer Variablen vom Typ `Set<String>`. Geben Sie alle Elemente dieser Menge mithilfe der Methode `printSet()` auf der Konsole aus. Was beobachten Sie in Bezug auf die Anzahl der Elemente im Vergleich zur Anzahl der Elemente in der Liste? Warum ist das so?
	4. Erstellen Sie eine Methode `public static Set<String> createTreeSet(String[] words)`. In dieser Methode soll eine `TreeSet` erstellt werden. Alle Elemente in dieser Liste sind vom Typ `String`. Befüllen Sie diese Menge (`Set`) mit allen Wörtern aus dem `words`-Array. Die Methode gibt die befüllte Menge (`Set`) zurück. 
	5. Erstellen Sie in der `main()`-Methode mithilfe der Methode `createTreeSet(words)` eine Menge und speichern Sie diese Menge in einer Variablen. Geben Sie alle Elemente dieser Menge mithilfe der Methode `printSet()` auf der Konsole aus. Was beobachten Sie in Bezug auf die Sortierung der Elemente im Vergleich zur `HashSet`?

	**Zusatz**

	1. Erstellen Sie für die Liste eine Methode `public static List<String> findDoublets(List<String> list)`. Diese Methode erstellt eine Liste, in der alle Elemente enthalten sind, die in `list` doppelt vorkommen. Diese Elemente werden dann auch doppelt in die Resultat-Liste übernommen. Geben Sie diese Liste mithilfe der `printList()`-Methode in der `main()`-Methode aus.

	??? "Mögliche Ausgabe (je nach Reihenfolge des Aufrufs der Methoden)"

		```bash
		Liste mit 16 Elementen :
		--------------------------
		Linux
		Apple
		Facebook
		Amazon
		IBM
		Lenovo
		Google
		IBM
		Microsoft
		Apple
		Google
		Twitter
		Skype
		Chrome
		Linux
		Firefox
		Index des ersten Auftretens von Apple  : 1
		Index des letzten Auftretens von Apple : 9
		erstes Element in der Liste  : Linux
		letztes Element in der Liste : Firefox

		Liste mit 13 Elementen :
		--------------------------
		Linux
		Amazon
		IBM
		Lenovo
		IBM
		Microsoft
		Apple
		Google
		Twitter
		Skype
		Chrome
		Linux
		Firefox

		Doublets-
		Liste mit 4 Elementen :
		--------------------------
		Linux
		IBM
		IBM
		Linux

		ohne Doublets-
		Liste mit 9 Elementen :
		--------------------------
		Amazon
		Lenovo
		Microsoft
		Apple
		Google
		Twitter
		Skype
		Chrome
		Firefox

		Menge mit 12 Elementen :
		--------------------------
		Lenovo
		Google
		Apple
		Skype
		Linux
		IBM
		Twitter
		Chrome
		Microsoft
		Amazon
		Facebook
		Firefox

		Menge mit 12 Elementen :
		--------------------------
		Amazon
		Apple
		Chrome
		Facebook
		Firefox
		Google
		IBM
		Lenovo
		Linux
		Microsoft
		Skype
		Twitter
		```


??? question "mögliche Lösung für Übung 4"
	
	=== "Uebung4.java"
		```java linenums="1"
		package uebungen.uebung4.loesung;

		import java.util.ArrayList;
		import java.util.HashSet;
		import java.util.Iterator;
		import java.util.List;
		import java.util.Set;
		import java.util.TreeSet;

		public class Uebung4 {

			//A1. Erstellen Sie eine Methode public static List<String> createArrayList(String[] words). 
			//In dieser Methode soll eine ArrayList erstellt werden. Alle Elemente in dieser Liste sind vom Typ String. 
			//Befüllen Sie diese Liste mit allen Wörtern aus dem words-Array. Die Methode gibt die befüllte Liste (List) zurück.
			public static List<String> createArrayList(String[] words){
				// neue ArrayList mit String als Type anlegen
				List<String> list = new ArrayList<>();

				// jedes Element aus words in die Liste einfügen
				for(int i=0; i<words.length; i++) {
					list.add(words[i]);
				}

				return list;		
			}


			//A2. Erstellen Sie eine Methode public static void printList(List<String> list). 
			//Diese Methode gibt alle Elemente der Liste list auf der Konsole aus. 
			//Geben Sie auch die Anzahl der Elemente der Liste aus.
			public static void printList(List<String> list)
			{
				//Variante 1: Iterator
				System.out.println("--Iterator--");					
				Iterator<String> it = list.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}


				//Variante 2: for-Schleife
				System.out.println("--Schleife--");
				for(String s : list)
				{
					System.out.println(s);
				}

				//Anzahl der Elemente ausgeben
				System.out.println("Die Liste hat "+ list.size() + " Elemente.");
			}

			//B1. Erstellen Sie eine Methode public static Set<String> createHashSet(String[] words). 
			//In dieser Methode soll eine HashSet erstellt werden. 
			//Alle Elemente in dieser Liste sind vom Typ String. 
			//Befüllen Sie diese Liste mit allen Wörtern aus dem words-Array. 
			//Die Methode gibt die befüllte Menge (Set) zurück.
			public static Set<String> createHashSet(String[] words)
			{
				Set<String> set = new HashSet<>();		
				for(int i=0; i<words.length; i++) {
					set.add(words[i]);
				}
				return set;	
			}

			//B2. Erstellen Sie eine Methode public static void printSet(Set<String> set). 
			//Diese Methode gibt alle Elemente der Menge set auf der Konsole aus. 
			//Geben Sie auch die Anzahl der Elemente der Menge aus. 
			public static void printSet(Set<String> set)
			{
				for(String s : set)
				{
					System.out.println(s);
				}

				System.out.println("Das Set hat "+ set.size() + " Elemente.");
			}

			//B4. Erstellen Sie eine Methode public static Set<String> createTreeSet(String[] words). 
			//In dieser Methode soll eine TreeSet erstellt werden. 
			//Alle Elemente in dieser Liste sind vom Typ String. 
			//Befüllen Sie diese Menge (Set) mit allen Wörtern aus dem words-Array. 
			//Die Methode gibt die befüllte Menge (Set) zurück. 
			public static Set<String> createTreeSet(String[] words)
			{		
				Set<String> set = new TreeSet<>();
				for(int i=0; i<words.length; i++) {
					set.add(words[i]);
				}
				return set;	
			}

			//Zusatz: Erstellen Sie für die Liste eine Methode public static List<String> findDoublets(List<String> list). 
			//Diese Methode erstellt eine Liste, in der alle Elemente enthalten sind, die in list doppelt vorkommen. 
			//Diese Elemente werden dann auch doppelt in die Resultat-Liste übernommen. 
			//Geben Sie diese Liste mithilfe der printList()-Methode in der main()-Methode aus.
			public static List<String> findDoublets(List<String> list)
			{
				//Grundidee 
				//Beispiel-Liste: "a" "b" "a" "c" "a"

				//Index:  0 1 2 3 4
				//Inhalt: a b a c a

				//erster Index von "a": 0
				//letzter Index von "a":4 
				//0 != 4 -> es gibt Duplikate 
				//erster Index von "b":1
				//letzter Index von "b":1
				//1 == 1 -> keine Duplikate, also diesen Eintrag als Einzeleintrag merken
				//...

				//leere Liste "singles" für Einzeleinträge anlegen
				List<String> singles = new ArrayList<>();

				//durch list iterieren und testen ob das Element Duplikate hat, 
				//wenn nicht in "singles" speichern 
				Iterator<String> it = list.iterator();
				//it = copy.iterator();
				while(it.hasNext()) {
					String s = it.next();
					if(list.indexOf(s) == list.lastIndexOf(s)) singles.add(s);
				}

				//Kopie von list anlegen
				List<String> copy = new ArrayList<>();
				it = list.iterator();
				while(it.hasNext()) copy.add(it.next());

				//alle singles aus der kopierten Liste entfernen
				copy.removeAll(singles);
				return copy;
				//um zu testen, warum die Kopie nötig ist:
				//copy.removeAll(singles); und return copy; ersetzen durch
				//list.removeAll(singles); 
				//return list;
				//und dann die Ausgabe von l2 in der main anschauen

			}

			public static void main(String[] args) {
				String[] words = {"Linux", "Apple", "Facebook", "Amazon", "IBM", "Lenovo", "Google", "IBM", "Microsoft", "Apple", "Google", "Twitter", "Skype", "Chrome", "Linux", "Firefox"};

				System.out.println("---------- A ----------");
				//A3. Erstellen Sie in der main()-Methode mithilfe der Methode createArrayList(words) eine 
				//Liste und speichern Sie diese Liste in einer Variablen vom Typ List<String>. 
				List<String> l1 = createArrayList(words);		
				//Geben Sie alle Elemente dieser Liste mithilfe der Methode printList() auf der Konsole aus. 
				printList(l1);

				//A4. Ermitteln Sie den Index in der Liste, in der "Apple" das erste Mal auftaucht. 
				//Erzeugen Sie folgende Ausgabe:  Index des ersten Auftretens von Apple  : 1
				System.out.println("Index des ersten Auftretens von Apple: " + l1.indexOf("Apple"));

				//Ermitteln Sie den Index in der Liste, in der "Apple" das letzte Mal auftaucht. 
				//Erzeugen Sie folgende Ausgabe: Index des letzten Auftretens von Apple : 9
				System.out.println("Index des letzten Auftretens von Apple: " + l1.lastIndexOf("Apple"));

				//Geben Sie den Wert des ersten Elementes der Liste aus. 
				//Erzeugen Sie folgende Ausgabe: erstes Element der Liste : Linux
				System.out.println("erstes Element der Liste: " + l1.get(0));

				//Geben Sie den Wert des letzten Elementes der Liste aus. 
				//Erzeugen Sie folgende Ausgabe: letztes Element der Liste : Firefox
				System.out.println("letztes Element der Liste: " + l1.get(l1.size()-1));

				//Löschen Sie die Werte "Apple", "Google" und "Facebook". 
				//Geben Sie die Liste erneut mithilfe der printList(list)-Methode aus.
				//1. Möglichkeit: nur 1. Vorkommen löschen
				l1.remove("Apple");
				l1.remove("Google");
				l1.remove("Facebook");
				printList(l1);
				//2. Möglichkeit: alle löschen
				while(l1.remove("Apple"));
				while(l1.remove("Google"));
				while(l1.remove("Facebook"));
				printList(l1);

				System.out.println("---------- B ----------");
				System.out.println("-------HashSet------");
				//B3. Erstellen Sie in der main()-Methode mithilfe der Methode createHashSet(words) 
				//eine Menge und speichern Sie diese Menge in einer Variablen vom Typ Set<String>. 
				Set<String> h1 = createHashSet(words);
				//Geben Sie alle Elemente dieser Menge mithilfe der Methode printSet() auf der Konsole aus. 
				//Was beobachten Sie in Bezug auf die Anzahl der Elemente im Vergleich zur Anzahl der Elemente 
				//in der Liste? Warum ist das so?
				printSet(h1);

				System.out.println("-------TreeSet------");
				//B5. Erstellen Sie in der main()-Methode mithilfe der Methode createTreeSet(words) 
				//eine Menge und speichern Sie diese Menge in einer Variablen. 
				Set<String> t1 = createTreeSet(words);
				//Geben Sie alle Elemente dieser Menge mithilfe der Methode printSet() auf der Konsole aus. 
				//Was beobachten Sie in Bezug auf die Sortierung der Elemente im Vergleich zur HashSet? 
				printSet(t1);

				System.out.println("-------Duplicates------");
				List<String> l2 =  createArrayList(words);	
				List<String> d = findDoublets(l2);
				printList(d);	
				printList(l2);
			}

		}
		```


##### Übung 5 (Maps)

??? "Übung 5"

	1. Erstellen Sie eine Klasse `Stadt` mit folgenden Objektvariablen:
		- `String name;`
		- `List<Integer> bevoelkerung;`
		- `float flaeche;`

	2. Erstellen Sie für die Klasse `Stadt` einen parametrisierten Konstruktor `public Stadt(String name, List<Integer> bevoelkerung, float flaeche)`, der die Objektvariablen initialisiert.
	3. Erstellen Sie für die Klasse `Stadt` eine `print()`-Methode, so dass eine Ausgabe auf der Konsole in folgender Form erscheint (Bsp.):
		```bash
		Berlin             891,68 km2    3.382.169   3.460.725   3.574.830
		```
	4. Erstellen Sie eine Klasse `StadtTest` mit `main()`-Methode. Kopieren Sie in die Klasse die Methode `public static Stadt[] staedte()` hinein:
		```java
		public static Stadt[] staedte()
		{
			Stadt[] staedte = new Stadt[6];
			List<Integer> berlinBevoelkerung = new ArrayList<>();
			berlinBevoelkerung.add(3382169);	
			berlinBevoelkerung.add(3460725);	
			berlinBevoelkerung.add(3574830);
			staedte[0] = new Stadt("Berlin", berlinBevoelkerung, 891.68f);
			
			List<Integer> hamburgBevoelkerung = new ArrayList<>();
			hamburgBevoelkerung.add(1715392);	
			hamburgBevoelkerung.add(1786448);	
			hamburgBevoelkerung.add(1810438);	
			staedte[1] = new Stadt("Hamburg", hamburgBevoelkerung, 755.22f);
			
			List<Integer> muenchenBevoelkerung = new ArrayList<>();
			muenchenBevoelkerung.add(1210223);	
			muenchenBevoelkerung.add(1353186);	
			muenchenBevoelkerung.add(1464301);
			staedte[2] = new Stadt("Muenchen", muenchenBevoelkerung, 310.70f);
			
			List<Integer> koelnBevoelkerung = new ArrayList<>();
			koelnBevoelkerung.add(962884);	
			koelnBevoelkerung.add(1007119);	
			koelnBevoelkerung.add(1075935);	
			staedte[3] = new Stadt("Koeln", koelnBevoelkerung, 405.02f);
			
			List<Integer> frankfurtBevoelkerung = new ArrayList<>();
			frankfurtBevoelkerung.add(648550);	
			frankfurtBevoelkerung.add(679664);	
			frankfurtBevoelkerung.add(736414);
			staedte[4] = new Stadt("Frankfurt/Main", frankfurtBevoelkerung, 248.31f);
			
			berlinBevoelkerung = new ArrayList<>();
			berlinBevoelkerung.add(3382169);	
			berlinBevoelkerung.add(3460725);	
			berlinBevoelkerung.add(3574830);
			staedte[5] = new Stadt("Berlin", berlinBevoelkerung, 891.68f);
			
			return staedte;
		}		
		```

	**Liste**

	5. Erstellen Sie in der `main()`-Methode eine `List<Stadt> staedteListe = new ArrayList<>();`. Fügen Sie der `staedteListe` alle Städte aus dem durch Aufruf der `staedte()`-Methode erzeugtem Array zu.
	6. Geben Sie alle Informationen über alle Städte aus der Liste unter Verwendung der `print()`-Methode aus der Klasse `Stadt` aus.

	**Menge**

	5. Erstellen Sie in der `main()`-Methode eine `Set<Stadt> staedteMenge = new HashSet<>();`. Fügen Sie der `staedteMenge` alle Städte aus dem durch Aufruf der `staedte()`-Methode erzeugtem Array zu.
	6. Geben Sie alle Informationen über alle Städte aus der Liste unter Verwendung der `print()`-Methode aus der Klasse `Stadt` aus.
	7. Berlin erscheint doppelt, obwohl eine Menge keine doppelten Elemente enthalten darf. Warum?

	**Stadt - Teil 2**

	5. Implementieren Sie in der Klasse `Stadt` die `equals(Object)`- und die `hashCode()`-Methode.
	6. Führen Sie danach die `StadtTest`-Klasse erneut aus. Was hat sich an der Menge geändert?

	**Maps**

	5. Erstellen Sie in der `main()`-Methode eine `Map<Integer, Stadt> staedteMap = new HashMap<>();`. Fügen Sie der `staedteMap` einen fortlaufenden, eindeutigen `Integer`-Wert beginnend mit `1` als *Key* sowie alle alle Städte aus dem durch Aufruf der `staedte()`-Methode erzeugtem Array als *Value* hinzu.
	6. Geben Sie alle Informationen über alle Städte aus der Liste unter Verwendung der `print()`-Methode aus der Klasse `Stadt` aus. Beginnen Sie die Zeile jeweils mit der Ausgabe des *Keys*.

	**Ausgaben**

	```bash
	------------ Liste --------------
	Berlin             891,68 km2    3.382.169   3.460.725   3.574.830
	Hamburg            755,22 km2    1.715.392   1.786.448   1.810.438
	Muenchen           310,70 km2    1.210.223   1.353.186   1.464.301
	Koeln              405,02 km2      962.884   1.007.119   1.075.935
	Frankfurt/Main     248,31 km2      648.550     679.664     736.414
	Berlin             891,68 km2    3.382.169   3.460.725   3.574.830

	------------ Menge --------------
	Frankfurt/Main     248,31 km2      648.550     679.664     736.414
	Berlin             891,68 km2    3.382.169   3.460.725   3.574.830
	Muenchen           310,70 km2    1.210.223   1.353.186   1.464.301
	Koeln              405,02 km2      962.884   1.007.119   1.075.935
	Hamburg            755,22 km2    1.715.392   1.786.448   1.810.438

	------------ Maps --------------
	1  Berlin            891,68 km2    3.382.169   3.460.725   3.574.830
	2  Hamburg           755,22 km2    1.715.392   1.786.448   1.810.438
	3  Muenchen          310,70 km2    1.210.223   1.353.186   1.464.301
	4  Koeln             405,02 km2      962.884   1.007.119   1.075.935
	5  Frankfurt/Main    248,31 km2      648.550     679.664     736.414
	6  Berlin            891,68 km2    3.382.169   3.460.725   3.574.830
	``` 


