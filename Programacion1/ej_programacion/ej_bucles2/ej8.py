'''8.Design a program that asks for a set of numbers. After inputting each number, theprogram should ask 
“Do you want to enter more numbers (Y/N)?”. If the answer is “Y”the program asks for other numbers. 
When the user finishes to enter all the numbers,the program should say which one is the smallest. 
The messages are the following:“Enter one number:”“Do you want to enter more number (Y/N)?”“
The smallest number is XX'''

'''def numeroMenor(n):
    #n= int(input("Ingrese un número: "))
    pregunta="y"
    
    while pregunta.lower()== str("y"):
        n1=int(input("Ingresa otro numero: "))
        pregunta = input("Quiere introducir otro numero (Y/N)")
        if n<n1:
            if pregunta.lower()==str("n"):
                print(str(n) + " es el menor")
        elif n1<n:
            n=n1
            if pregunta.lower()==str("n"):
                print(str(n) + " es el menor")
        else:
            if pregunta.lower()==str("n"):
                print("Los numeros son iguales")
                    
print(numeroMenor(n=int(input("Ingrese un numero"))))'''
    
'''def programaPrincipal():
    lista=obtenernumeros()
    print(obtenerElMenorElemento(lista))
    
def obtenerNumeros():
    listaNumeros = 
    return listaNumeros'''
    
def pideNumeros():
    num=int(input("Ingrese un numero"))
    
    listaNumeros=[]
    listaNumeros.append()
    
    pregunta="y"
    
    while pregunta.lower()== str("y"):
        num=int(input("Ingresa otro numero: "))
        pregunta = input("Quiere introducir otro numero (Y/N)")
        listaNumeros.append(num)
    
        print(obtenerElMenorElemento(listaNumeros))
    
#Esta funcion devuelve el elemento menor de una lista numerica.
def obtenerElMenorElemento(numbers):
    menor=numbers[0] #empezamos con numbers[0] porque corresponde con el primer numero de la lista
    for i in numbers:
        if i<menor:
            menor=i
    
            
    
    #return menor
pideNumeros()

'''assert(obtenerElMenorElemento([3,7,9])==3)
assert(obtenerElMenorElemento([3,7,0])==0)
assert(obtenerElMenorElemento([30,7,-2])==-2)

print(obtenerElMenorElemento([3,5,4,9,6]))'''


