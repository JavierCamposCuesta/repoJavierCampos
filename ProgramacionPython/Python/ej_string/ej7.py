'''
Diseñar una función que reciba como parámetro tres cadenas, la primera será una frase y deberá buscar si existe 
la palabra que recibe como segundo parámetro y reemplazarla por la tercera.
Created on 27 Nov 2020

@author: estudiante
'''

def reemplazarPalabra(texto, palabra, reemplazo):
     textoNuevo=""
     contador=0
     for i in texto:
         print(i)
         if texto[i] == palabra[0]:
             for c in range(0, len(palabra)):
                 
             print("hola")
         print(texto[i])
reemplazarPalabra("hola como feo esta chaval, una pena ser tan feo", "feo", "malito")


def buscarReemplazar (frase, palabra, reemplazo):
    cadenaFinal= ""
    indicadorPosicionFrase=0
    reemplazo=reemplazo+" "
    while  indicadorPosicionFrase < len(frase):
        coincidencia=True
        indPalabra =0
        
        while coincidencia and indPalabra < len(palabra):
            if not palabra[indPalabra]==frase[indicadorPosicionFrase+indPalabra]:
                coincidencia=False
            indPalabra+=1
        if not coincidencia:
            cadenaFinal+=frase[indicadorPosicionFrase]
        else:
            for i in reemplazo:
                cadenaFinal+=i
            indicadorPosicionFrase+=len(palabra)
        indicadorPosicionFrase+=1
    return cadenaFinal
print(buscarReemplazar("hola como estas cojones sevilla es una maravilla", "sevilla", "malaga"))     