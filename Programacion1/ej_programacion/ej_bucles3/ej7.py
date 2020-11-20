'''
Escriba una función que reciba un entero y devuelva si representa un año bisiesto o no, según la regla, 
“Un año es bisiesto si es divisible por 400, o bien si es divisible por 4 pero nopor 100” .
Por ejemplo, el año 2000 es bisiesto (es divisible por 400), el año 1992 es bisiesto (es divisible por 4 y no por 100), 
y el año 2100 no es bisiesto (es divisible por 4 y también por 100 y no por 400)
Created on 20 Nov 2020

@author: estudiante
'''
def calculaBisiesto():
    year = int(input("Introduce el año"))
    if (year % 400== 0) or (year%4==0 and year % 100 != 0):
        print(str(year)+ " es bisiesto")
    else:
        print(str(year) + " no es bisiesto")
calculaBisiesto()
