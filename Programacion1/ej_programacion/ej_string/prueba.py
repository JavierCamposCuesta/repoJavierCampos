'''
Created on 30 nov. 2020

@author: Javier
'''
def elimina_vocales(s):
    vocales = "aeiouAEIOU"
    s_sin_vocales = ""
    for letra in s:
        if letra not in vocales:
            s_sin_vocales += letra
    print( s_sin_vocales)
elimina_vocales("hola que HacEs cojones")