'''Ejercicio 1  Diseñar un programa que calcule el perímetro de una figura geométrica. Para ello debemos preguntar “¿Cuántos lados
tiene la figura?”. Luego debemos pedir la longitud de cada uno de los lados y mostrar el perímetro. Se debe garantizar que 
los datos son correctos.
Created on 17 Nov 2020

@author: estudiante
'''
def calculaPerimetro():
    lados=int(input("¿Cuantos lados tiene la figura?"))
    contador =0
    perimetro=0
    while lados>contador:
        longitud=float(input("Introduce la longitud de un lado"))
        if longitud>0:
            perimetro=longitud+perimetro
            contador = contador +1
        else:
            print("La longitud tiene que ser positiva")
    print("El perimetro total es de: "+str( perimetro))
calculaPerimetro()




    