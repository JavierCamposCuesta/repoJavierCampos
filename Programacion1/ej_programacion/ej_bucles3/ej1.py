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
    mayor=0
    suma=0
    if lados>0:
        while lados>contador:
            longitud=float(input("Introduce la longitud de un lado"))
            if longitud>0:
                if longitud>mayor:
                    mayor=longitud
                perimetro=longitud+perimetro
                contador = contador +1
                suma=longitud+suma
            else:
                print("La longitud tiene que ser positiva")
        if mayor>(suma-mayor):
            print("El poligo no es correcto, no puede cerrarse")
        else:
            print("El perimetro total es de: "+str( perimetro))
    else:
        print("Tiene que ser un numero positivo")
calculaPerimetro()




    