'''
9. Diseñe un método llamado numberDivisorPrime que reciba un número positivo como parámetro. 
El método debe devolver el número de divisores primos del parámetro. Si el parámetro no es 
válido, el método debería devolver -1.
Created on 14 dic. 2020

@author: Javier
'''
#Utilizo la funcion de un ejercicio anterior donde veiamos si el numero era primo o no
def isPrime(numero):
    solucion=1
    if numero>1:
        for i in range(2, numero-1):
            if numero%i==0:
                solucion=0
    else:
        solucion=-1   
    return solucion

def numberDivisorPrime(number):
    divisoresPrimos=[]
    for i in range (1, number+1):
        if number%i==0:
            if isPrime(i)==1:
                divisoresPrimos.append(i)
    return len(divisoresPrimos)
print(numberDivisorPrime(63))
        