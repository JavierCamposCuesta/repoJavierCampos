'''un numero capicuo es cuando se leen igual de delante hacia atrás que de atrás a delante, las palabras palindromas es 
lo mismo pero con palabras.
Design a function called palindrome that has a string of characters as parameter, and return true if it is a 
palindrome or false in other case. A word is a palindrome, if it is reads the same from left to right as from right to left, 
ignoring whites,. For example: "anilina" or "el abad le dio arroz al zorro" To simplify the problem, you can assume that 
simple characters are used, that is, without tildes or diresis.
Created on 24 Nov 2020

@author: estudiante
'''

def palindromo(cadena):
    inversa=(" ")
    cadena=cadena.replace(" ", "")

    for i in range (0, len(cadena)):
        inversa = cadena[i] + inversa
    
    if inversa == cadena:
        print("Es capicua")
    elif inversa != cadena:
        print("No es capicua")
     
    print(inversa)
    print(cadena)
  
print(palindromo("a"))
print(palindromo("hola que hace"))
print(palindromo("ana"))
'''
def esPalindroma2(cadena):
    esPalindroma = True
    cadena=str(cadena)
    
    for i in range(0, len(cadena)//2):
        sonIguales =(cadena[i] == cadena[len(cadena)-1 -i])
        
        if not sonIguales:
            esPalindroma = False
    return esPalindroma

print(esPalindroma2("CnanX"))
print(esPalindroma2("ana"))
print(esPalindroma2(33388333), type(33388333))
print(esPalindroma2("33388333"), type("33388333"))
print(esPalindroma2(3338.8333), type(3338.8333))'''













