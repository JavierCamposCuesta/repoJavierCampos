'''
Realizar un programa que nos sirva para crear el id de usuario que nuestros empleados utilizar�n 
para conectarse a nuestras aplicaciones. El programa debe preguntarle al usuario su nombre y sus 
apellidos, separando los datos por coma. Es decir si me preguntan a mi yo debo poner Jos�Manuel,
Sevillano,Armenta (puedes suponer que nos van a dar los valores bien). Luego debe preguntar el 
dni, debe comprobar que se trata de un dni v�lido, si no es v�lido volver a preguntarlo hasta que 
nos d� un dni v�lido. Por �ltimo debe llamar a una funci�n que devuelva el id. Para calcular el 
id le pasaremos la cadena con el nombre y apellidos y crear� el id con los tres primeros 
caracteres del nombre, los tres �ltimos del primer apellido , los tres primeros del segundo 
apellido y los tres primeros n�meros del dni.
Created on 2 Dec 2020

@author: estudiante
'''
from Examen.ej2 import dni1
            


def CreaID():
    nombre=input("Introduce su nombre y apellidos separados por comas")
    
    fin=0
    while fin==0:
        print(dni1(numero=int(input("Introduce los numeros de su dni")), letra=input("Introduce la letra de su dni")))
        if dni1:
            fin=1
            print(creaId(nombre))
CreaID()

def creaId(cadena):
    id=""
    for i in range (0, len(cadena)):
        if i <= 0 or i==1 or i==2:
            id=id+cadena[i]
        elif cadena[i]==",":
            id=id+cadena[i+1]+cadena[i+2]+cadena[i+3]
    return (id+numero[0]+numero[1]+numero[2])
creaId("Javier,Campos,cuesta")

#No estan funcionando por separado, pero individualmente, cada una cumple su funcion