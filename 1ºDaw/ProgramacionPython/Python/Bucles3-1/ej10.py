'''
Diseñe un método llamado amigo que reciba dos números positivos como parámetros.
 El método debe devolver verdadero si el número son amigos y falso en otro caso.
  Dos números son amigos si la suma de todos los divisores menos el mismo número de 
  un número es igual al segundo número y en el otro caso también. Si los parámetros no 
  son válidos, el método debe devolver falso
Created on 14 dic. 2020

@author: Javier
'''

def amigo(number1, number2):
    sumaDivisoresNumber1=0
    sumaDivisoresNumber2=0
    if number1>0 and number2>0:
        for i in range (1, number1+1):
            if number1%i ==0:
                sumaDivisoresNumber1+=i
        for i in range (1, number2+1):
            if number2%i ==0:
                sumaDivisoresNumber2+=i
        return ((sumaDivisoresNumber1-number1)==number2) and (sumaDivisoresNumber2-number2==number1)
        
assert(amigo(220, 284))
assert(amigo(225, 282)==False)
assert(amigo(1184, 1210))

        