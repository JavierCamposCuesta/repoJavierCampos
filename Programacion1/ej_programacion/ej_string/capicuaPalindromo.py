'''un numero capicuo es cuando se leen igual de delante hacia atrás que de atrás a delante, las palabras palindromas es 
lo mismo pero con palabras.
Design a function called palindrome that has a string of characters as parameter, and return true if it is a 
palindrome or false in other case. A word is a palindrome, if it is reads the same from left to right as from right to left, 
ignoring whites,. For example: "anilina" or "el abad le dio arroz al zorro" To simplify the problem, you can assume that 
simple characters are used, that is, without tildes or diresis.
Created on 24 Nov 2020

@author: estudiante
'''
lista=[]
lista2=[]
nombre= str(input("Introduce un numero o una palabra"))
for i in range  ( len(nombre)):
    lista.append(nombre[i])
for i in range (len(nombre) -1, -1, -1):
    lista2.append(nombre[i])
if lista.strip() == lista2.strip():
    print("Es capicua")
else:
    print("No es capicua")
print(lista)
print(lista2)
hola=str(" hola        que hace ")
newhola=hola.replace(" ", "")
print(newhola)

