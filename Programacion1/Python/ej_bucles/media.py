'''Realizar un programa que solicite n numeros e imprima la media de los 
numeros. '''
cantidadn = int(input("Cuantos numeros va a introducir"))
suma=0
for i in range(0,cantidadn):
    suma = suma+float(input("Introduce un numero"))
print(suma/cantidadn)