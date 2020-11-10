'''7.Design a program that asks how many numbers the user wants to write. After theuser enters all numbers,
 the program should say the medium of the numbers. If theuser inputs a wrong number, the program should 
 ask for it again. The messages arethe following:“How many numbers do you want input?” to ask for the 
 number of numbers.“Enter one number greater than 0:” to ask for a number.“The number is not valid, 
 it should be greater than 0” to inform that the number is notvalid.“The medium is XX.XX” to show the
  result'''
 
cantidadn = float(input("Cuantos numeros quiere introducir? "))
i=0
suma=0
while i < cantidadn:
    n=int(input("Introduce un numero mayor que 0 = "))
    if n >0:
        i=i+1
        suma=n+suma
    else:
        print("El numero tiene que ser mayor que 0")
print("La media es: " + str(suma/cantidadn))