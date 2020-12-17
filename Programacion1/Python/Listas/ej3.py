'''
3.    Lee por teclado números y guardalo en una lista, el proceso finaliza cuando metamos
 un número negativo. Muestra el máximo de los números guardado en la lista, muestra los 
 números pares.
Created on 17 dic. 2020

@author: Javier
'''
def pideNumeros():
    lista=[]
    numero=int(input("Introduce un numero:"))
    while numero>0:
        lista.append(numero)
        numero=int(input("Introduce un numero: "))
    return lista

def calcula(lista):
    maximo=len(lista)
    listaPares=[]
    for i in lista:
        if i%2==0:
            listaPares.append(i)
    return maximo, listaPares
print(calcula(pideNumeros()))
        