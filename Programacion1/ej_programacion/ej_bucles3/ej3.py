'''Diseñar un programa que lea números hasta que el usuario introduzca el 0. Debe informar dela media de los números 
leídos (sin tener en cuenta el 0) y el valor máximo y mínimo introducido.
Created on 17 Nov 2020

@author: estudiante
'''
def calculaMedia():
    number=(int(input("Introduce un numero")))
    listaNumeros=[]
    listaNumeros.append()
    while  number != 0:
        listaNumeros.append(number)
        number=(int(input("Introduce un numero")))
        
    listaNumeros.sort()   
    print("El numero maximo es: " + lista[1])
    print("El numero minimo es: " + lista[-1])
    listaNumeros.sort()
    
        
    