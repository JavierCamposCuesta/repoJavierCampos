'''
se generara un numero aleatorio de 4 cifras,
se intenta adivinar, sino se adivina devuelve XXXX si se adivina alguno se va mostrando
Created on 16 dic. 2020

@author: Javier
'''
from random import randint

numeroAzar=(randint(1000,9999))
numero=int(input("Adivina el numero: "))
if numeroAzar!=numero:
    contador=0
    while int(numeroAzar)!=numero:
        if numero>999 and numero<10000:
            numeroAzar=str(numeroAzar)
            numero=str(numero)
            contador+=1
            comprobador=0
            solucion=""
            for i in range(0,4):
                if numeroAzar[i]!=numero[i]:
                    solucion+="X"
                else:
                    solucion+=numeroAzar[i]
            print(solucion)
            
        else:
            print("Numero no valido")
        numero=int(input("Introduce otro numero: "))
    print("OLEEEEEEEEE "+ str(numero)+ " es el numero , maquinon")
        
                
    
else:
    print("Eres el puto amo, lo has acertado a la primera")

    
    