'''Design a function called charactersInString that has a character string and a character as input parameters and returns how many times that character appears in the string. It should do if the string and character are  lower case or upper case characters
Created on 25 Nov 2020

@author: estudiante
'''
def characterInString(cadena, caracter):
    suma=0
    #cadena=str(input("Introduce una cadena de caracteres"))
    #caracter=str(input("Introduce un caracter"))
    for i in range(0, len(cadena)):
        if caracter.lower()== cadena[i].lower():
            suma= suma+1
    #print(suma)
    
    return suma

assert(characterInString("hola que haces chulo", "a")==2)
assert(characterInString("hola que haces chulo", "e")==2)
assert(characterInString("hola que haces chulo", "o")==2)
assert(characterInString("hola que haces chulo", "u")==2)
assert(characterInString("hola que haces chulo", "i")==0)

    