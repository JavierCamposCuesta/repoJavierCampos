'''4.Design a program that reads a positive number N greater than 0 and show the resultof the sum of the N 
numbers between 1 and N. If the number N is not valid, theprogram should ask for it again. 
The messages are the following:“Enter one number greater than 0:”“The number is not right, try again.
”“The sum of the N first numbers is XX.'''

suma=0
while suma== 0:
    cantidadn = int(input("Cuantos numeros quiere introducir? "))
    if cantidadn>0:
        for i in range(1, cantidadn+1):
            suma=suma+i
        print(suma)
    else:
        print("Error")
        
'''Mismo ejercicio pero con while'''
        
suma1=0
while suma1 ==0:
    cantidadn1=int(input("Introduce un numero"))
    if cantidadn1>0:
        while cantidadn1>0:
            suma1=suma1+cantidadn1
            cantidadn1=cantidadn1 - 1
        print(suma1)
