'''. Escribir una función que, devuelva el número de palabras que hay en una cadena que recibe
como parámetro. Ten en cuenta que entre dos palabras puede haber más de un blanco.
También al principio y al final de la frase puede haber blancos redundantes.
Por ejemplo, si la cadena es “He estudiado mucho”, debe devolver 3
Created on 30 nov. 2020

@author: Javier
'''
def contadorPalabras(cadena):
    contador=0
    i=0
    while cadena[i]==" ":
        i+=1
    
    for i in range (i, len(cadena)-1):
        if cadena[i]==" ":
            contador+=1
            while i<len(cadena) and cadena[i]==" ":
                i=i+1
                    
    if cadena[i-1] !=" ":
        contador+=1    
    
    return contador
        
            
print(contadorPalabras(" Hola   que hace como estamos cojones "))