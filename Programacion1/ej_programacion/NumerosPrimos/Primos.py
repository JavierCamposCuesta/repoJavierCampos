'''
Created on 11 Nov 2020

@author: estudiante
'''
'''Esta funcion devueove True si el valor introducido como argumento es un numero primo y False en caso contrario'''

def esNumeroPrimo(numero):
    for i in range(2, numero):
        if numero%i==0:
            return False
        
    return True
      
print(esNumeroPrimo(int(input("Introduce un numero para saber si es primo"))))      
            




        