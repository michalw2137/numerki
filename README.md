Obserwacje:
- aby odwzorować wielomian N stopnia potrzeba N+1 węzłów
- im więcej węzłów tym lepsze odwzorowanie
- interpolacja nie lubi ostrych czubków, szczególnie w centrum, gdzie węzły są rzadziej


- czemu zagęszczamy na brzegach??


https://pl.wikipedia.org/wiki/Wielomiany_Czebyszewa

https://pl.wikipedia.org/wiki/Interpolacja_wielomianowa

https://pl.wikipedia.org/wiki/Węzły_Czebyszewa

http://www.geol.agh.edu.pl/~mpapiez/MN/zajecia5.html

Wariant 3: Lagrange'a na węzłach Czebyszewa

Program ma umożliwiać wczytanie stablicowanych wartości funkcji oraz umożliwiać wybór jednej z kilku funkcji: liniowa, |x|, wielomian, trygonometryczna i ich złożenia. Wartości wielomianów *interpolowanych* należy obliczać używając schematu Hornera. Wartości wielomianów *interpolacyjnych* należy obliczać bezpośrednio, skorzystanie ze schematu Hornera nie jest bowiem możliwe bez uprzedniego przekształcenia wielomianu interpolacyjnego do postaci kanonicznej. Użytkownik wybiera funkcję, przedział interpolacji oraz liczbę węzłów interpolacyjnych. Dla równoodległych odstępów argumentu oraz węzłów Czebyszewa położenie węzłów wyliczane jest z odpowiednich wzorów, dla nierównych odstępów argumentu trzeba zapewnić możliwość wczytania położenia węzłów w sposób przyjazny dla użytkownika (plik albo odpowiednia kontrolka GUI). Wartości w węzłach interpolacyjnych wyliczane są przy użyciu funkcji wybranej przez użytkownika. Program ma rysować wykres funkcji oryginalnej i wielomianu interpolującego oraz zaznaczać węzły interpolacji (węzły interpolacji powinny pokrywać się z punktami przecięcia wykresów funkcji i wielomianu interpolacyjnego - jeśli jest inaczej, to jest to wyraźna oznaka błędu w programie).

W sprawozdaniu należy zamieścić przykładowe wykresy. Zbadać w jaki sposób zmiana liczby węzłów wpływa na dokładność interpolacji. Ile węzłów potrzeba do interpolacji wielomianu N-tego stopnia?

- [x] wczytanie stablicowanych wartości funkcji 
- [x] wybór funkcji
  - [x] liniowa
  - [x] moduł
  - [x] wielomian
  - [x] trygonometryczna
  - [x] złożenia ?
- [x] wybór przedziału interpolacji
- [x] położenie węzłów wyliczane z wzoru Czebyszewa
- [x] wartości w węzłach wyliczane wybraną funkcją
- [x] rysowanie oryginalnego wykresu
- [x] rysowanie wielomianu interpolującego
  - [x] zaznaczyć węzły interpolacji
  - [x] wartości w węzłach pokrywają się z wykresem
  

- [x] wartości wielomianów interpolowanych obliczane Hornerem
- [x] wartości wielomianów interpolacyjnych obliczane bezpośrednio

