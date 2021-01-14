'''
Created on 30 Oct 2020

@author: JavierCampos
'''
'''10.Design a program that reads an integer positive number and says the “factorial” ofthe number. 
To calculate the factorial you should know thatFACT(0)= 1FACT(1) =1FACT(N)= N*(N-1)*(N-2)*....
1The messages are the following:“Enter an integer positive number:”“The number is not valid, try again.
”“The factorial is X'''
'''Calcular el factorial de un numero'''

def factorial(n):
    total=1
    if n>=0:
        while n>1:
            total=total*n
            n=n-1
        return total
    elif n<0 and n%2==0:
        n=-n
        while n>1:
            total=total*n
            n=n-1
        return total
    elif n<0 and n%2!=0:
        n=-n
        while n>1:
            total=total*n
            n=n-1
        return -total
        
print(factorial(int(input("Introduce un numero: "))))

#assert(factorial(1)==1)
#assert(factorial(3)==6)
#assert(factorial(5)==120)
#assert(factorial(6)==720)
''' el  mismo programa pero con un solo bucle'''
def factorialcorto(n):
    fact=1
    n2=0
    if n>=0 and n%2==0:
        n=-n
    if n>=0 and n%2!=0:
        n2=n+1
        n=1
        '''Cuando el numero es positivo y par le cambiamos el signo, pero cuando es positivo
        e impar lo que hacemos es modificar el bucle'''
    for i in range (n, n2):
        fact=fact * i
    return(fact)
print(factorialcorto(n=int(input("Introduce un numero"))))
