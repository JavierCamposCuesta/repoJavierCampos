'''
6.    Design a method called numberOfNumbers that receives one integer positive number as 
parameter. The method should return the number of digits of the number that received by 
parameter. If the parameter is not valid the method should return -1.
Created on 10 dic. 2020

@author: Javier
'''

def numberOfNumbers(numero):
    contador=0
    if numero>0:
        numero=str(numero)
        for i in range(len(numero)):
            contador+=1
    else:
        contador=-1
    return contador
assert(numberOfNumbers(452)==3)
assert(numberOfNumbers(-456)==-1)
assert(numberOfNumbers(1234)==4)
assert(numberOfNumbers(4)==1)
assert(numberOfNumbers(456456)==6)
      