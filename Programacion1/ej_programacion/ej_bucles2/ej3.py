'''3.Design a program that asks how many numbers the user wants to introduce. Then,the user would have 
to introduce the numbers one by one and the program shouldsay if each one of the numbers is odd or even. 
If the user inputs 0 or a negativenumber, it is not valid, and the system should ask for another number. 
The messagesare the following:“How many numbers do you want input?” to ask for the number of numbers.
“Enter one number greater than 0:” to ask for a number.“The number is not valid, it should be greater than 0”
 to inform that the number is notvalid.“The number XX is odd”“The number XX is even'''
 
cantidadn = int(input("Cuantos numeros quiere introducir? "))
i=0
par=0
while i < cantidadn:
    n=int(input("Introduce un numero mayor que 0 = "))
    if n >0:
        i=i+1
        if n%2==0:
            print("El numero " + str(n) + " es par")
            par=par+1
        else:
            print("El numero " + str(n) + " es impar")
    else:
        print("El numero tiene que ser mayor que 0")
print("Has introducido " + str(par) + " numeros pares")
print("Has introducido " + str(cantidadn-par) + " numeros impares")
    
    
        
    
 
