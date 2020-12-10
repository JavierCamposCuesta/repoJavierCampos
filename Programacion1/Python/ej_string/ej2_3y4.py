'''2.Design a function called lowCaseInString that has a string of characters as parameter, the method should return 
how many of those characters are lowcase letters.

3.Design a function called upperCaseInString that has a string of 
characters as parameter, the method should return how many of those characters are upper case letters.
Created on 25 Nov 2020

4.Design a function called numberInString that has a string of characters as parameter, the method should return how 
many of those characters are numbers.

@author: estudiante
'''
from curses.ascii import islower, isupper

def lowCaseInString(cadena):
    cantidad=0
    for i in cadena:
        if isupper(i)==True:
            cantidad+=1
    print(cantidad)
    return cantidad

def upperCaseInString(cadena):
    cantidad=0
    for i in cadena:
        if islower(i)==True:
            cantidad+=1
    print(cantidad)
    return cantidad

'''def numberInString(cadena):
    cantidad=0
    for i in cadena:
        if isNumber(i)==True:
            cantidad+=1
    print(cantidad)
    return cantidad'''


assert(lowCaseInString("Hola Que Haces")==3)
assert(lowCaseInString("Hola QuE HaCes")==5)
assert(lowCaseInString("Hola Que haces")==2)

assert(upperCaseInString("Hola QUE haces")==8)
assert(upperCaseInString("HoLA QUE haces")==6)
assert(upperCaseInString("Hola QUE Haces")==7)

'''assert(numberInString("456")==3)
assert(numberInString("Hola 69 que 5  456846")==9)
assert(numberInString("Hola  que haces ")==0)'''





        