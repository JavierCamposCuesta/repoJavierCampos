'''
8.    Design a method called secondOrder that receives three integer positive number as 
parameters. This parameters are the coefficients of the an equation of a second order 
(ax2+bx+c=0) and the method returns the numbers of the solutions. If the parameters are 
not valid the method should return -1
Created on 14 dic. 2020

@author: Javier
'''
from math import sqrt

def pideNumeros():
    a=float(input("Introduce el valor de a: "))
    b=flotat(input("Introduce el valor de b: "))
    c=float(input("Introduce el valor de c: "))
    return a, b, c

def secondOrder(a,b,c):
    resultado=[]
    if a<=0 or b<0 or c<=0 or (b**2)-(4*a*c)<0:
    
        resultado.append(-1)
    else:
        x1=(-b+sqrt((b**2)-(4*a*c)))/(2*a)
        x2=(-b-sqrt((b**2)-(4*a*c)))/(2*a)
        resultado.append(x1)
        resultado.append(x2) 
    return resultado
print(secondOrder(1,1,1))
    


    