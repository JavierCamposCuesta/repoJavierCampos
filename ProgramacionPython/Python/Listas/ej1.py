'''
    1. Crea un programa que genere 1OO números de forma aleatoria y que 
    posteriormente ofrezca al usuario la posibilidad de:
        1. Conocer el mayor de los números
        2. Conocer el menor de los números
        3. Obtener la suma de todos los números
        4. Obtener la media d ellos números
        5. Sustituir el valor de un elemento por otro número introducido por teclado.
        6. Mostrar todos los números.
    Realiza las opciones con funciones.
Created on 16 Dec 2020

@author: estudiante
'''
from random import randint

def numerosAleatorios():
    listaNumeros=[]
    for i in range(100):
        listaNumeros.append(randint(0,1000))
    return listaNumeros

def numeroMayor(listaNumeros):
    mayor=0
    for i in listaNumeros:
        if i>mayor:
            mayor=i
    return mayor

def numeroMenor(listaNumeros):
    menor=1000
    for i in listaNumeros:
        if i <menor:
            menor=i
    return menor

def sumaNumeros(listaNumeros):
    suma=0
    for i in listaNumeros:
        suma+=i
    return suma

def mediaNumeros(listaNumeros):
    return sumaNumeros(listaNumeros)/len(listaNumeros)

def sustituirNumero(listaNumeros):
    numero=int(input("¿Que numero quiere sustituir? "))
    listaNueva=[]
    while numero not in listaNumeros:
        numero=int(input("El numero anterior no se encuentra, elija otro:  "))
    sustituto=int(input("¿Por que numero quiere sustituirlo? "))
    while sustituto in listaNumeros:
        sustituto=int(input("El numero anterior ya se encuentra, elija otro:  "))
    for i in listaNumeros:
        if i==numero:
            listaNueva.append(sustituto)
        else:
            listaNueva.append(i)
    return listaNueva
    
def main():
    mensaje= ''''
    1. Conocer el mayor de los números
    2. Conocer el menor de los números
    3. Obtener la suma de todos los números
    4. Obtener la media d ellos números
    5. Sustituir el valor de un elemento por otro número introducido por teclado.
    6. Mostrar todos los números.'''
    print(mensaje)
    opcion=int(input("Elije una opcion: "))
    opciones=[0, numeroMayor(numerosAleatorios()), numeroMenor(numerosAleatorios()), mediaNumeros(numerosAleatorios()),sustituirNumero(numerosAleatorios()),numerosAleatorios()]
    return opciones[opcion]
print(main())






    