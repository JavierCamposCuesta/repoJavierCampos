'''
Created on 3 Nov 2020

@author: javier Campos
'''
'''Design a program that reads an integer positive number greater than 0 and says if
it’s a “perfect number”. A number is perfect if it is equal to the sum of all its divisors.
The messages are the following:
“Enter an integer positive number greater than 0:”
“The number is not valid, try again.”
“The number is perfect.”
“The number is not perfect.”'''

def nperfecto(n):
    suma=0
    '''while 0==0:'''
    '''n = int(input("Introduce un numero: "))'''
    if n>0:
        for i in range (1, n):
            if n % i==0:
                suma=suma+i
        return(n==suma)
        '''if suma == n:
            #print("El número es perfecto " + str(n))'''
            
def compruebaNumeros():
    numero=0
    
    while numero <=0:
        numero=int(input("introduce un numero"))
        if numero <=0:
            print("El numero no es valido")
        elif nperfecto(numero):
            print("El numero es perfecto")
        else:
            print("El numero no es perfecto")
        
compruebaNumeros()
              

'''for n in range(1, 100000):
    nperfecto(n)
print("fin")'''

'''print(nperfecto(6))
print(nperfecto(28))
print(nperfecto(496))
print(not nperfecto(15))
print(not nperfecto(45))
print("Fin")'''