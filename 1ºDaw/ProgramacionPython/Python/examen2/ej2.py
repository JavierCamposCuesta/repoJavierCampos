'''
Programar un validador de dni
Created on 8 dic. 2020

@author: Javier
'''

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
                print("El dni es correcto")
                return cadenaDNI
            else:
                print("El dni no es correcto")
        else:
            print("El dni introducido no es correcto")
    
    
pideDNI()


    
        
        
            
        
    