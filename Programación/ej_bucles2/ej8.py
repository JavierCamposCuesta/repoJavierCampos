def nperfecto(n):
    suma=0
    '''while 0==0:'''
    '''n = int(input("Introduce un numero: "))'''
    if n>0:
        for i in range (1, n):
            if n % i==0:
                suma=suma+i
            if suma == n:
                print("El número es perfecto " + str(n))
                    
                
              

for n in range(1, 100):
    nperfecto(n)
                    
    
    




