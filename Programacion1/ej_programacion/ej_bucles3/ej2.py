'''Diseñar un programa que pida dos números, la base y la potencia, y muestre el resultado de elevar la base a la potencia 
sin usar el operador de potencia, es decir, sólo con multiplicaciones. Hay que tener en cuenta que la potencia puede ser 
negativa.
Created on 17 Nov 2020

@author: estudiante
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
calculaPotencia(base=int(input("base")), exponente=int(input("exponente")))
    
#assert(calculaPotencia(2, 10)==1024)
#assert(calculaPotencia(-3, -3)==round(-0.037))
#assert(calculaPotencia(-4, 3)==-64)
