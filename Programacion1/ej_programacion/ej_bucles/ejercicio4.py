
'''4.Disenar un programa que pida un numero entero y nos muestre los 10 siguientes 
numeros que son multiplos de 5.'''

n = int(input("Introduzca un numero"))
for i in range(n+1, n+51):
    if  i % 5 == 0 :
        print(i)