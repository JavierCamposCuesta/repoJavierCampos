'''
Realiza un programa que lea 10 números, debe imprimir los 10 número y después desplazarlos una posición, 
de tal forma que el último pase a la primera posición, el primero a la segunda, el segundo a la tercera, 
y así sucesivamente
Created on 17 Dec 2020

@author: estudiante
'''
def mueveNumeros():
    lista=[1,2,3,4,5,6,7,8,9,10]
    listaNueva=[]
    for i in range (len(lista)):
        if i<len(lista)-1:
            listaNueva.append(lista[i])
        else:
            listaNueva.insert(0,lista[i])
    return lista, listaNueva


def mueveNumeros1():
    lista=[1,2,3,4,5,6,7,8,9,10]
    listaNueva=[]
    listaNueva.append(lista[-1])
    for i in range(len(lista)-1):
        listaNueva.append(lista[i])
    return lista, listaNueva
print(mueveNumeros1())
        


    