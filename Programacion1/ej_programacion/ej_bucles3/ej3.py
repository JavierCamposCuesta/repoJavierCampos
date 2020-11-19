'''Diseñar un programa que lea números hasta que el usuario introduzca el 0. Debe informar dela media de los números 
leídos (sin tener en cuenta el 0) y el valor máximo y mínimo introducido.
Created on 17 Nov 2020

@author: estudiante
'''

def numerosEnLista():
    listaNumeros=[ ]
    while  not 0 in listaNumeros:
        listaNumeros.append(float(input("Introduce un numero")))
    listaNumeros.remove(0)
        
    listaNumeros.sort()   
    print("""El numero maximo es: """+ str(listaNumeros[-1]))
    print("El numero minimo es: " + str(listaNumeros[0]))
    print("la media es: " + str(sum(listaNumeros) / len(listaNumeros)))
numerosEnLista()


    
        
    