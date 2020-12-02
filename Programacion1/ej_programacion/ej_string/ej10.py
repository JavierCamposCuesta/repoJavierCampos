<<<<<<< HEAD
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


def contarPalabraOptimo(texto):
    numPalabras =0
    temporal= " "
    
    for i in texto:
        if temporal == " ":
            if i != " ":
                numPalabras+=1
            temporal = i
    return numPalabras
print(contarPalabraOptimo("Hola que haces estamos aqui contando palabras"))
    
    
    
    
    
    
    
    
        
        
            

=======
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
>>>>>>> 40b3aca1c9883aeff46214db197b878f03015e46
