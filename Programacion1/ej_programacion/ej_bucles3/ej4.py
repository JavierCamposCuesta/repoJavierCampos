'''Diseñar un programa que muestre un menú con las siguientes opciones:
1.Cambio de euros a dólares
2.Cambio de dólares a euros
3.Cambio de euros a libras
4.Cambio de libras a euros.
5.Cambio de libras a dólares
6.Cambio de dólares a libras
7.Salir
El programa debe pedir una opción, luego una cantidad según corresponda y mostrar la conversión correspondientes. 
El programa terminará cuando pulse un 7
Created on 18 Nov 2020

@author: estudiante
'''
def eurosDolares(cantidad):
    print(str(cantidad) + " euros, equivale a " + str(cantidad*1.19) + " dolares")
def dolaresEuros(cantidad):
    print(str(cantidad) + " dolares, equivale a " + str(cantidad*0.84) + " euros")
def eurosLibras(cantidad):
    print(str(cantidad) + " euros, equivale a " +str( cantidad*0.9) + " libras")
def librasEuros(cantidad):
    print(str(cantidad) + " libras, equivale a " +str( cantidad*1.12) + " euros")
def librasDolares(cantidad):
    print(str(cantidad) + " libras, equivale a " +str( cantidad*1.33) + " dolares")
def dolaresLibras(cantidad):
    print(str(cantidad) + " dolares, equivale a " +str( cantidad*0.75) + " libras")

def conversorMoneda():
    print("1.Cambio de euros a dólares")
    print("2.Cambio de dólares a euros")
    print("3.Cambio de euros a libras")
    print("4.Cambio de libras a euros.")
    print("5.Cambio de libras a dólares")
    print("6.Cambio de dólares a libras")
    print("7.Salir")
    opcion=1
    while opcion!=7:
        opcion=int(input("Que opcion quiere realizar: "))
        if opcion >0 and opcion<=6:
            cantidad=float(input("Introduce la cantidad: "))
            #if type(cantidad) == int:
            if opcion == 1:
                eurosDolares(cantidad)
            elif opcion==2:
                dolaresEuros(cantidad)
            elif opcion==3:
                eurosLibras(cantidad)
            elif opcion==4:
                librasEuros(cantidad)
            elif opcion==5:
                librasDolares(cantidad)
            else:
                dolaresLibras(cantidad)
           # else:
                print("Tiene que ser un valor numerico")
        else:
            print("El numero introducido no es valido, prueba otra vez")
conversorMoneda()
        

    
        