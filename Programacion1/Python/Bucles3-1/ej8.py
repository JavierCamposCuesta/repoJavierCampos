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
    x1=(-b+sqrt((b**2)-(4*a*c)))/(2*a)
    x2=(-b-sqrt((b**2)-(4*a*c)))/(2*a)
    return x1, x2
print(secondOrder(3, 2, 7))
    


    