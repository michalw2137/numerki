- funkcje:

	- wielomian
	- trygonometryczna
	- wykładnicza
	- ich złożenia ???
	
	customowy wielomian - podajemy stopień i kolejne współczynniki
	
	przykłady:
	
		x^3 - x^2 -2x + 1 = 0
		
		2^x -3x = 0
		
		3x + sin(x) - e^x = 0
		
		x^3 -x + 1 = 0
		
		tg(x) - 1 = 0
		
		2 + cos(2x) = 0
		
		sin(x) - cos(x) = 0		 
		
Działanie programu:

	- wyświetl dostępne wzory funkcji i poproś o wybór
	- pokaż wykres funkcji (???)
	- zapytaj o wybranie zakresu - lewy i prawy kraniec
		- sprawdź, czy wartości na krańcach mają przeciwne znaki
	- zapytaj o wybranie warunku stopu - ilość iteracji/osiągnięcie epsilona
	- zapytaj o ilość iteracji/wartość epsilona
	- wykonaj obliczenia bisekcją
	- wykonaj obliczenia metodą siecznych
	
	- podaj wyniki dla obu metod:
		ile iteracji potrzeba do osiągnięcia zadanej dokładności
		która jest szybsza?
			- wybrano osiągnięcie epsilona: policz ilość iteracji

		jaką dokładność osiąga każda metoda dla określonej liczby iteracji
		która metoda jest dokładniejsza?
			- wybrano ilość iteracji: policz dokładność

	Co się dzieje, jeśli znak pochodnej nie jest stały na przedziale?
	Zamieścić w sprawozdaniu przykład ilustrujący taką sytuację.

Metoda siecznych:
	https://pl.wikipedia.org/wiki/Metoda_siecznych	
	
	
 pseudokod:
 
- fun liczIteracje(a, b):
	
		a = [a]
		b = [b]
		x = 0
		
		for i in range(ilosc_iteracji):

		licznik = fun(a[i]) * b[i] - fun(b[i]) * a[i]
		mianownik = fun(a[i]) - f(b[i-1]) # sus

		x = licznik / mianownik

		if fun(x) * fun(a[i]) > 0:
		a.append(x)
		b.append(b[i])

		if fun(x) * fun(b[i]) > 0:
		a.append(a)
		b.append(x)

		return x

- fun liczIteracje(a, b):

		a = [a]
		b = [b]
		x = 0

		i = 0
		while(fun(x) > epsilon)

		licznik = fun(a[i]) * b[i] - fun(b[i]) * a[i]
		mianownik = fun(a[i]) - f(b[i-1]) # sus

		x = licznik / mianownik

		if fun(x) * fun(a[i]) > 0:
		a.append(x)
		b.append(b[i])

		if fun(x) * fun(b[i]) > 0:
		a.append(a)
		b.append(x)

		i ++
		return x


