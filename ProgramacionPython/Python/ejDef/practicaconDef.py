'''
Created on 6 Nov 2020

@author: estudiante
'''
def divisiblePor7(number):
    return number%7==0

def divisiblePor13(number):
    return number%13==0

def divisiblePor17(number):
    return number%17==0

def test():
    assert(divisiblePor7(7)==True)
    assert(divisiblePor13(26)==True)
    assert(divisiblePor17(56)==False)
    assert(divisiblePor7(95)==False)
    assert(divisiblePor13(156)==True)
    assert(divisiblePor17(248)==False)
    assert(divisiblePor7(74)==False)
    assert(divisiblePor13(39)==False)

#Calcular si es divisible por 2 y 3 a la vez

def esDivisiblePor(numero, divisor):
    return numero % divisor == 0
def esDivisiblePor2(number):
    return esDivisiblePor(number, 2)

def esDivisiblePor3(number):
    return esDivisiblePor(number, 3)

def calculaTipoNumero(number):
    if esDivisiblePor2(number) and esDivisiblePor3(number):
        print("Es divisible por 2 y 3")
    elif esDivisiblePor2(number):
        print("Es divisible por 2")
    elif esDivisiblePor3(number):
        print("Es divisible por 3")

print(calculaTipoNumero(6))
print(calculaTipoNumero(123))
print(calculaTipoNumero(45))
print(calculaTipoNumero(268))
print(calculaTipoNumero(47))
print(calculaTipoNumero(47))


