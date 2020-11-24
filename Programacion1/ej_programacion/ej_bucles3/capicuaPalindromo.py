'''un numero capicuo es cuando se leen igual de delante hacia atrás que de atrás a delante, las palabras palindromas es 
lo mismo pero con palabras
Created on 24 Nov 2020

@author: estudiante
'''
lista=[]
lista2=[]
nombre= str(input("Introduce un numero o una palabra"))
for i in range  ( len(nombre)):
    lista.append(nombre[i])
for i in range (len(nombre), +1):
    lista2.append(nombre[-ii])
if lista == lista2:
    print("Es capicua")
else:
    print("No es capicua")
print(lista)
print(lista2)
