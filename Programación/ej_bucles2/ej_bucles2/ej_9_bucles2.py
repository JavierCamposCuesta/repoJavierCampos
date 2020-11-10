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
        if suma == n:
            print("El número es perfecto " + str(n))
                    
                
              

for n in range(1, 100000000):
    nperfecto(n)
print("fin")

       

    
