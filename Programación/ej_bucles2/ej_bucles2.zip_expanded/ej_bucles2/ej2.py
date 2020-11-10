'''Design a program for reading an integer between 0 and 10 and show the times table.To ask for the number 
you should show the next message "Enter one numberbetween 0 and 10”. If the number is out of the 
boundaries, the program should showthe message “The number is out of the boundaries”. If the number is 
valid, it shouldshow the times table following the next format:
7*0=07*1=7.....7*10=70+ bucle infinito pidiendo valores y tiempo de espera'''
import time
while 0==0:
    number = int(input("ingrese un numero entre 0 y 10 = "))
    if number >=0 and number<=10:
        for i in range (0,11):
            print(str(number) + str(" x ") +  str(i) + str(" = ") + str(number*i))
        time.sleep(2)
    else:
        print("Error")
    
        
