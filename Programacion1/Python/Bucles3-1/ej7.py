'''
7.    Design a method called isPrime that receives one integer positive number greater 
than 0 as parameter. The method should return 1 if the number is prime or 0 if the number is 
not prime. If the parameter is not valid the method should return -1.
Created on 10 dic. 2020

@author: Javier
'''
def isPrime(numero):
    solucion=0
    if numero>0:
        for i in range(2, numero-1):
            if numero%i==0:
                solucion=1
    else:
        solucion=-1   
    return solucion
assert(isPrime(17)==0)
assert(isPrime(6)==1)
assert(isPrime(-17)==-1)
assert(isPrime(-6)==-1)


                