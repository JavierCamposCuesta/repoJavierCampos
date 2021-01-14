'''Realizar un programa que solicite tres valores de los lados de un posible triángulo e informe si es un triángulo o no.
Created on 24 Nov 2020

@author: estudiante
'''
def calculaPerimetro():
    lados=3
    contador =0
    perimetro=0
    mayor=0
    suma=0
    if lados>0:
        while lados>contador:
            longitud=float(input("Introduce la longitud de un lado"))
            if longitud>0:
                if longitud>mayor:
                    mayor=longitud
                perimetro=longitud+perimetro
                contador = contador +1
                suma=longitud+suma
            else:
                print("La longitud tiene que ser positiva")
        if mayor>(suma-mayor):
            print("El triángulo no es correcto, no puede cerrarse")
        else:
            print("El perimetro total es de: "+str( perimetro))
    else:
        print("Tiene que ser un numero positivo")
calculaPerimetro()

def esTriangulo(lados):
    return len(lados)==3 and not ((lados[0]+lados[1] <=lados[2]) or 
                                  (lados[2] + lados[0] <= lados[1]) or 
                                  (lados[2]+lados[1] <= lados[0]))
print(esTriangulo([3,4,5]))
print(esTriangulo([5,6,4]))
print(esTriangulo([3,4,15]))
print(esTriangulo([3,15,5]))
print(esTriangulo([15,4,5]))
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    