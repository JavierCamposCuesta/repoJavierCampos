'''
En el gimnasio Jacafitness tienen el siguiente horario: 

    Los Lunes, Miércoles y Jueves imparten Spinning de 12 a 14, Yoga de 16 a 20 y Body combat de 20 a 22
    Los Martes y Viernes las sesiones de Spinning y Yoga se intercambian. 

Elabora un programa que dé la bienvenida al gimnasio Jacafitness y tras preguntar por la hora y 
el día de la semana te indique la actividad que puedes realizar.

@author: Javier Campos
'''
print("Buenos dias, esperamos poder ayudarte")
dia=input("Indique el dia que le gustaria comenzar (recuerda que los fines de semana no trabajamos): ")
dia=dia.lower()
hora=float(input("Indique la hora a la que le gustaría empezar (recuerda que abrimos de 12 a 22 horas): "))
if dia == str("lunes") or dia == str("miercoles") or dia== str("jueves"):
    if hora >= 12 and hora < 14:
        #considero que las clases empiezan a esa hora exacta y que si quiere empezar a las 14 no va a poder porque es cuando acaba la clase
        print("Puedes practicar Spinning")
    elif hora>=16 and hora <20:
        print("Puedes practicar Yoga")
    elif hora>=20 and hora <22:
        print("Puedes practicar Body Combat")
    else:
        print("La hora introducida no es valida")
elif dia == str("martes") or dia == str("viernes"):
    if hora >= 16 and hora < 20:
        print("Puedes practicar Spinning")
    elif hora>=12 and hora <14:
        print("Puedes practicar Yoga")
    elif hora>=20 and hora <22:
        print("Puedes practicar Body Combat")
    else:
        print("La hora introducida no es valida")
else:
    print("El dia introducido no es valido")
  

