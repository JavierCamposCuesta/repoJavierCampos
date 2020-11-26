'''
Diseñar una función que determine la cantidad de vocales diferentes, que tiene una palabra o frase introducida por teclado.
 Por ejemplo, la cadena “Abaco”, devolvería 2.
Created on 26 Nov 2020

@author: estudiante
'''
def vocalesDiferentes(cadena):
    contadorVocales=[]
    for i in cadena:
        if i == "a" or i=="e" or i=="i" or i=="o" or i=="u":
            if i not in contadorVocales:
                contadorVocales.append(i)
    return len(contadorVocales)
            
print(vocalesDiferentes("aaeeiioouu"))
print(vocalesDiferentes("Hola que ase"))
        
    