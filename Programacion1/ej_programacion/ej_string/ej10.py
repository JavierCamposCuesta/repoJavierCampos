'''Escribir una función que, devuelva el número de palabras que hay en una cadena que recibecomo parámetro. 
Ten en cuenta que entre dos palabras puede haber más de un blanco. También al principio y al final de la frase puede 
haber blancos redundantes.Por ejemplo, si la cadena es “He estudiado mucho”, debe devolver 3
Created on 1 Dec 2020

@author: estudiante
'''
def contarPalabras(cadena):
    palabra=""
    lista=[]
    for i in cadena:
        if i !=" ":
            palabra+=i
        if (i== " " or i==cadena[-1]) and palabra != "":
            lista.append(palabra)
            palabra=""
    return len(lista)
print(contarPalabras("HOla que haces     cojones aqui estamos  o que hace  "))
        
        
            

