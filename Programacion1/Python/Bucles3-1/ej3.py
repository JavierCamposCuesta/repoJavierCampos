'''
Design a method called daysInMonth that returns the integer number
 of days in the month and year that received as arguments. You can use 
 the method leapYear. If the arguments are not valid the method should 
 return -1
Created on 9 Dec 2020

@author: estudiante
'''
def leapYear(numero):
    if numero%4==0 and numero/400!=0 and numero/100!=0:
        return 1
    else:
        return -1

def daysInMonth(mes, year):
    diasMes=""
    if year ==1:
        if mes==1 or mes==3 or mes==5 or mes==7 or mes==8 or mes==10 or mes==12:
            diasMes=30
        elif mes==2:
            diasMes=28
        else:
            diasMes=30
    else:
        if mes==1 or mes==3 or mes==5 or mes==7 or mes==8 or mes==10 or mes==12:
            diasMes=30
        elif mes==2:
            diasMes=29
        else:
            diasMes=30
    return diasMes



print(daysInMonth(2, leapYear(2023)))
        