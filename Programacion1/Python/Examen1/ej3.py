'''Realiza un programa para obtener el máximo común divisor de dos números que se pedirán por teclado. El máximo común divisor 
es el mayor número que divide a ambos números a la vez.
Created on 4 Nov 2020

@author: Javier Campos
'''
def mcd(n, n2):
  
    mcd=1
    menor=n
    if n>0 and n2>0:
        if n2 < n:
            menor=n2
    #necesito para acabar el bucle saber cual es el numero menor   
        for i in range (1,menor+1):
            if int(n) % i==0 and int(n2) % i == 0:
                mcd=i
        print("El minimo comun divisor es: " + str(mcd))
    else:
        print("los numeros tienen que ser positivos")
    return(mcd)
def test():
    assert(mcd(3, 3)==3)
    assert(mcd(4, 16)==4)
    assert(mcd(45, 5)==6)
test()