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

def numeroMayor():
    mayor=0
    for i in numerosAleatorios():
        if i>mayor:
            mayor=i
    return mayor

def numeroMenor():
    menor=1000
    for i in numerosAleatorios():
        if i <menor:
            menor=i
    return menor

def sumaNumeros():
    suma=0
    for i in numerosAleatorios():
        suma+=i
    return suma

def mediaNumeros():
    return sumaNumeros()/100







    