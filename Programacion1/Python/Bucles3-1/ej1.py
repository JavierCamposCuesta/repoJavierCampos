'''
Design a method called factorial that receives a positive integer and 
returns the factorial. If the number is negative the method should return 
-1.
Created on 9 Dec 2020

@author: estudiante
'''


def factorial(numero):
    factorial=1
    if numero<=0:
        factorial=-1
    else:
        for i in range (1, numero+1):
            factorial*=i
    return factorial
print(factorial(-2))

        
    