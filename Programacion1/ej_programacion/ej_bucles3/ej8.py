'''
Realizar un programa que pregunte el número de partidos jugados en esta jornada. 
Luego para cada uno de las jornadas debe preguntar el número de goles del equipo local y del equipo visitante 
y el programa debe determinar el resultado de la quiniela. Debe asegurarse que los valores son correctos
Created on 20 Nov 2020

@author: estudiante
'''
mensaje =" "
fin=0
partido=1
while fin == 0:
    partidos = int(input("¿Cuantos partidos se han jugado esta jornada"))
    if partidos >0:
        for i in range (0, partidos):
            print("Resultado partido "+str( partido))
            local = int(input("Goles local: "))
            visitante=int(input("Goles visitante: "))
            if local > visitante:
                quiniela= 1
            elif visitante > local:
                quiniela = 2
            else:
                quiniela ="X"
                
            mensaje+="""
            jornada """  + str(partido)+ " = " + str(local) + " - " + str(visitante) + " quiniela -> " + str(quiniela)
            partido=1+partido
            fin =1
        print(mensaje)
    else:
        print("Tiene que ser un numero positivo")
