T0 										= 1
T1 										= x
T2 = 2x * x - 1 						= 2x^2 - 1
T3 = 2x * (2x^2 - 1) - x 				= 4x^3 - 3x
T4 = 2x * (4x^3 - 3x) - (2x^2 - 1) 		= 8x^4 - 8x^2 + 1

wielomian k-tego stopnia ma k m0

na brzegach rób częściej

liczba węzłów - stopień wielomianu k = ilość m0

2x(2x(2x(2x(x) - 1) - x) - 2x(x) - 1) - 2x(2x(x) - 1) - x)

https://pl.wikipedia.org/wiki/Wielomiany_Czebyszewa
https://pl.wikipedia.org/wiki/Interpolacja_wielomianowa
https://pl.wikipedia.org/wiki/Węzły_Czebyszewa
http://www.geol.agh.edu.pl/~mpapiez/MN/zajecia5.html

Wariant 3: Lagrange'a na węzłach Czebyszewa

Program ma umożliwiać wczytanie stablicowanych wartości funkcji oraz umożliwiać wybór jednej z kilku funkcji: liniowa, |x|, wielomian, trygonometryczna i ich złożenia. Wartości wielomianów *interpolowanych* należy obliczać używając schematu Hornera. Wartości wielomianów *interpolacyjnych* należy obliczać bezpośrednio, skorzystanie ze schematu Hornera nie jest bowiem możliwe bez uprzedniego przekształcenia wielomianu interpolacyjnego do postaci kanonicznej. Użytkownik wybiera funkcję, przedział interpolacji oraz liczbę węzłów interpolacyjnych. Dla równoodległych odstępów argumentu oraz węzłów Czebyszewa położenie węzłów wyliczane jest z odpowiednich wzorów, dla nierównych odstępów argumentu trzeba zapewnić możliwość wczytania położenia węzłów w sposób przyjazny dla użytkownika (plik albo odpowiednia kontrolka GUI). Wartości w węzłach interpolacyjnych wyliczane są przy użyciu funkcji wybranej przez użytkownika. Program ma rysować wykres funkcji oryginalnej i wielomianu interpolującego oraz zaznaczać węzły interpolacji (węzły interpolacji powinny pokrywać się z punktami przecięcia wykresów funkcji i wielomianu interpolacyjnego - jeśli jest inaczej, to jest to wyraźna oznaka błędu w programie).

W sprawozdaniu należy zamieścić przykładowe wykresy. Zbadać w jaki sposób zmiana liczby węzłów wpływa na dokładność interpolacji. Ile węzłów potrzeba do interpolacji wielomianu N-tego stopnia?

- [ ] wczytanie stablicowanych wartości funkcji
- [ ] wybór funkcji
  - [ ] liniowa
  - [ ] moduł
  - [x] wielomian
  - [x] trygonometryczna
  - [ ] złożenia ?
- [x] wybór przedziału interpolacji
- [ ] położenie węzłów wyliczane z wzoru Czebyszewa
- [ ] wartości w węzłach wyliczane wybraną funkcją
- [ ] rysowanie oryginalnego wykresu
- [ ] rysowanie wielomianu interpolującego
  - [ ] zaznaczyć węzły interpolacji
  - [ ] wartości w węzłach pokrywają się z wykresem
  

- [ ] wartości wielomianów interpolowanych obliczane Hornerem
- [ ] wartości wielomianów interpolacyjnych obliczane bezpośrednio
