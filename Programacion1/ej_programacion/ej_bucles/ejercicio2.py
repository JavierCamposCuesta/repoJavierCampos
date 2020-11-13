'''2.Disenar un programa que pida dos numeros. Debera ver cual de ellos 
es menor y mostrar todos los numeros comprendidos entre el valor menor y 
mayor, incluyendo ambos numeros.'''

n1 = int(input("Introduce el número"))
n2 = int(input("Introduce otro número"))
if n1 < n2:
    for i in range(n1, n2+1):
        print(i)
elif n2 < n1:
    for i in range(n2, n1+1):
        print(i)
else:
    print("Los números son iguales")
    
'''Otra forma de hacerlo'''

while n1<n2:
    print(n1)
    n1 = n1 + 1
while n2<n1:
    print(n2)
    n2 = n2+1