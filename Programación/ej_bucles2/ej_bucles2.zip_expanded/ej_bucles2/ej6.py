'''6.Design a program that reads two integer numbers, for example numberA andnumberB, and calculates 
the product of both numbers without use multiplication, butusing the sum. The messages are the following:
“Enter one number:”“The product is XX”'''

i=0
total=0
n1=int(input("Introduce el primer numero"))
n2=int(input("Introduce el segundo numero"))
for i in range(0, n2):
    total=total+n1
print(total)