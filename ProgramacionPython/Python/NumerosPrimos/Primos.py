'''
Created on 11 Nov 2020

@author: estudiante
'''
'''Esta funcion devueove True si el valor introducido como argumento es un numero primo y False en caso contrario'''
'''Crea un programa que pida al usuario un entero mayor que 0 y muestre por la saida estanr todos los numeros primos 
comprendidos entre el numero 1 y el facilitado por el usuario. Devuelve los resultados en una estructura de lista y haz uso 
de la funcion desarrollada previamente'''

def esNumeroPrimo(numero):
    for i in range(2, numero):
        if numero%i==0:
            return False
        
    return True
      
   

def pideNumeros(number):
    lista=[]
    for i in range(1, number+1):
        if esNumeroPrimo(i):
            lista.append(i)
    print(lista)
        
pideNumeros(int(input("Introduce un numero para saber si es primo")))     
        
            




        