'''5.Design a program that asks for numbers until the user inputs a negative one. Whenthis happens, 
the program will show how many positive numbers have beenintroduced by the user. The messages are the 
following:“Enter a number (negative to finish):” “You have entered XX positive numbers.'''

def contadorpositivos():
    fin=0
    i=0
    while fin==0:
        n=int(input("Introduce  un numero, (negativo para terminar) = "))
        if n >0:
            i=i+1
        else:
            print("Fin")
            fin=1
    print("Has introducido " + str(i) + " numeros positivos")

contadorpositivos()





        


