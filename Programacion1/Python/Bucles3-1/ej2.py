'''
Design a method called leapYear that returns 1 if the number that 
receives the method is a leap year. In other case, the method returns 
-1. A year is a leap year if it is multiple of 4 but the year is not 
multiple of 100 and not multiple of 400.
Created on 9 Dec 2020

@author: estudiante
'''
def leapYear(numero):
    if numero%4==0 and numero/400!=0 and numero/100!=0:
        return 1
    else:
        return -1
print(leapYear(2000))