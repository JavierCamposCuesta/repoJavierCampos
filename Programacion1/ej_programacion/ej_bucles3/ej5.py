'''Realizar un programa que solicite la coordenada x e y de un punto e informe si se encuentre en el primer, segundo, 
tercer o cuarto cuadrante.
Created on 19 Nov 2020

@author: estudiante
'''
def coordenadas():
    x=float(input("Introduce la coordenada x: "))
    y=float(input("Introduce la coordenada y: "))
    if x > 0 and y >0:
        print("Nos encontramos en el segundo cuadrante")
    elif x < 0 and y <0:
        print("Nos encontramos en el tercer cuadrante")
    elif x==0 and y ==0:
        print("Nos encontramos en el origen")
    elif x==0:
        print("Nos encontramos en el eje de la x")
    elif y==0:
        print("Nos encontramos en el eje de la y")
    elif x > 0 :
        print("Nos encontramos en el cuarto cuadrante")
    elif y >0 :
        print("Nos encontramos en el primer cuadrante")
coordenadas()