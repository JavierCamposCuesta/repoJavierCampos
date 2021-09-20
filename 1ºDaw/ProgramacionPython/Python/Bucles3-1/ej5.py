'''
5.    Design a method called myPower that receives one integer and one integer positive
 numbers as parameters and the method calculates the power of the first parameter raised 
 the second number. You only can use the multiplication. If the parameters are not right 
 (the second parameter is negative) the method should return -1. Remember that any number
  raised 0 is 1
Created on 9 dic. 2020

@author: Javier
'''
def calculaPotencia(base, exponente):
    #base=int(input("Introduce la base"))
    #exponente=int(input("introduce el exponente"))
    resultado=1
    if exponente<0:
        base=1/base
        exponente=-exponente
    for i in range (0, exponente): #@UnusedVariable
            resultado=resultado*base
    print(resultado)
    #return resultado
calculaPotencia(base=int(input("base: ")), exponente=int(input("exponente: ")))
    
#assert(calculaPotencia(2, 10)==1024)
#assert(calculaPotencia(-3, -3)==round(-0.037))
#assert(calculaPotencia(-4, 3)==-64)