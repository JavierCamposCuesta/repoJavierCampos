'''6.Design a program that reads two integer numbers, for example numberA andnumberB, and calculates 
the product of both numbers without use multiplication, butusing the sum. The messages are the following:
“Enter one number:”“The product is XX”'''
def multiplicacionsuma(n1, n2):
    total=0
    #n1=int(input("Introduce el primer numero"))
    #n2=int(input("Introduce el segundo numero"))
    if n1 and n2 >=0:
        for i in range(0,  n2): # @UnusedVariable
            total=total+n1
        print(total)    
    elif n1 <0 and n2<0:
        for i in range(0, -n2): # @UnusedVariable
            total=total-n1
        print(total)
    elif n1 <0:
        for i in range(0, n2): # @UnusedVariable
            total=total-n1
        print(total)
    else:
        for i in range(0, -n2): # @UnusedVariable
            total=total+n1
        print(-total)
   

    
multiplicacionsuma(int(input("Ingresa un numero ")),int(input("Ingresa otro numero ")))

#otra forma mas corta

def multiplicacorto (num1, num2):
    result=0
    if (num2<0 and num1>=0) or (num1>=0 and num2>=0):
        num2=0-num2
        num1=0-num1
    for i in range (num1,0):    #otra forma mas corta # @UnusedVariable
        result=result+num2
    return (-result)
print(multiplicacorto(num1=int(input("Escribe el primer numero")), num2=(int(input("Escribe el segundo valor")))))
