'''Design a program to show all numbers between 1 and 100. If the number is amultiple 
of 7 you should show the message "The number xx is a multiple of 7". If thenumber is 
a multiple of 13 you should show the message "The number xx is amultiple of 13". If 
the number is a multiple of 7 and 13 you should show bothmessages.'''


for i in range (1, 101):
    if i%7 ==0 and i%13==0:
        print(str(i) + " es multiplo de 7 y 13")
    elif i%7 == 0:
        print(str(i) + " es multiplo de 7")
    elif i%13 == 0:
        print(str(i) + " es multiplo de 13")
    else:
        print(str(i))