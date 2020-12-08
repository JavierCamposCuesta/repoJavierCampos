'''
introduce nombre y apellidos separados por comas
id=3 primeras letras del nombre 3 primera del los apellidos
Created on 8 dic. 2020

@author: Javier
'''
from sre_compile import isstring
def nombre():
    nombreCompleto=input("Introduce nombre y apellidos separados por comas(sin espacios): ")
    
    nombre=""
    for i in range (0, len(nombreCompleto)):
        if isstring(nombreCompleto[i]) and len(nombre)<3:
            nombre+=nombreCompleto[i]
        elif nombreCompleto[i]=="," and isstring(nombreCompleto[i+1]):
            nombre+=nombreCompleto[i+1]+nombreCompleto[i+2]+nombreCompleto[i+3]
    return nombre

def pideDNI():
    
    numeroDNI=""
    letraDNI=""
    fin=0
    while fin==0:
        cadenaDNI=(input("Introduce tu DNI con letra: "))
        for i in cadenaDNI:
            if i == "0" or i=="1" or i=="2" or i =="3" or i=="4" or i=="5" or i=="6" or i=="7" or i=="8" or i=="9":
                numeroDNI+=i
            else:
                letraDNI+=i
        if len(numeroDNI)==7 or len(numeroDNI)==8:
            letra="trwagmyfpdxbnjzsqvhlcke"
            letraBuena=letra[int(numeroDNI)%23]
            if letraBuena.lower()==letraDNI.lower():
                fin=1
                return numeroDNI[0]+numeroDNI[1]+numeroDNI[2]
            else:
                print("El dni no es correcto")
                numeroDNI=""
        else:
            print("El dni introducido no es correcto")
            numeroDNI=""

def idUsuario():
    idUsuario=nombre() + pideDNI()
    print(idUsuario)
    
idUsuario()
    



        
