'''5.Disenar un programa que muestre, para cada numero introducido por teclado,
 si es par, si es positivo y su cuadrado. El proceso se repetira hasta que el 
 numero introducido por teclado sea 0.'''
 
n=1
while n != 0:
    n =int(input("Introduce un numero"))
    if n % 2 == 0:
        print("El numero ", n , " es par")
    else:
        print("El numero ", n , " es impar")
    if n > 0:
        print("El numero ", n , " es positivo")
    else:
        print("El numero ", n , " es negativo")
    print("El cuadrado del ", n, " es: ", n**2)
