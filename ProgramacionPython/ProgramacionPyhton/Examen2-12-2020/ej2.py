'''
Created on 2 dic. 2020

@author: Javier
'''
'''
Realizar una funci�n que reciba como par�metro una cadena que contenga un dni y devuelva un True 
si el dni es v�lido y False en caso contrario. Para calcular la letra debemos tomar el n�mero 
completo de hasta 8 cifras de nuestro DNI, lo dividimos entre 23 y nos quedamos con el resto de 
dicha divisi�n.

El resultado anterior es un n�mero entre 0 y 22. A cada uno de estos posibles n�meros le 
corresponde una letra, seg�n la siguiente tabla:

Si el formato no es v�lido deber� devolver False.

Mejora opcional: Ten en cuenta que hay dni que en vez de 8 n�meros pueden tener 7.

Entrega las pruebas que has realizado
Created on 2 Dec 2020

@author: estudiante
'''
#lo he intentado de esta forma pero no me sale, la forma de abajo si funciona correctamente
def dni(cadena):
    numero=0
    resto=0
    letra="TRWAGMYFPDXBNJZSQVHLCKE"
    letraResultado=""
    for i in cadena:
        numero= numero +i
    print(numero)
    resto=numero %23
    print(numero)
    print(resto)
    letraResultado=letra[resto]
    print(cadena[-1])
    if str(cadena[-1])==str(letraResultado):
        print("True")
    else:
        print("False")
       
    print(numero)
    
#lo he intentado de la otra forma solo pidiendo una cadena pero me ha parecido mas complicado, de la forma que lo hago ahora lo veo mas simple y mas eficaz
def dni1(numero, letra):
    letraFija="TRWAGMYFPDXBNJZSQVHLCKE"
    resto=numero%23
    return letra.lower()==letraFija[resto].lower()
    
        
print(dni1(29497784, "R"))
print(dni1(29497784, "p"))
print(dni1(29497744, "z"))
assert(dni1(29497784, "p"))
assert(dni1(29497744, "z"))
print(dni1(29497784, "R")==False)