'''
 Estamos trabajando en una empresa que se dedica a realizar desafíos entre 
 dos contrincantes, por ejemplo, contrincante A y contrincante B. Un 
 revisor califica los dos desafíos, otorgando puntos en una escala del 1 al 
 100 para tres categorías: claridad del problema, originalidad y dificultad 
 a cada uno de los contrincantes.

Al final de la revisión tendremos un array o lista con las calificaciones 
del contrincante A y otro array o lista con las calificaciones del 
contrincante B. En cada array o lista tendremos la calificación a la
 claridad del problema, luego a la originalidad y luego a la dificultad 
 por cada uno de los retos. Por ejemplo si han realizado 2 retos, tenemos 
 el siguiente array para el contrincante A


50 80 20 60 70 75

Lo que indica que en el primer reto en claridad del problema obtuvo un 50, 
en originalidad un 80 y en dificultad un 20, y en el segundo reto obtuvo un
 60 en claridad del problema, un 70 en originalidad y un 75 en dificultad.

El contrincante que gana cada reto será el que obtenga más puntos sumando 
la claridad del problema, la originalidad y la dificultad.


Realizar una función que dado dos listas de calificaciones de los dos 
contrincantes, nos devuelva el número de partidas que ha ganado el primer
 contrincante.

Realizar un programa que usando la función anterior, pregunte cuántos 
retos van a jugar, luego pregunte la valoración para cada reto y cada 
participante, y por último informe de las partidas ganadas por cada 
participante.
Created on 18 Dec 2020

@author: estudiante
'''
#Con esta funcion calculo cual de los dos contrincantes ha tenido mas puntuacion en total
def revisor(contrincanteA, contrincanteB):
    retoA1=0
    retoB1=0
    retosGanadosA=0
    retosGanadosB=0
    puntuacionA=0
    puntuacionB=0
    for i in contrincanteA:
        puntuacionA+=i
    for i in contrincanteB:
        puntuacionB+=i
    return puntuacionA, puntuacionB

#Con esta funcion calculo las puntuaciones de cada reto y posteriormente calculo quien ha ganado mas retos para ver quien ha ganado la partida
def contaRetos(contrincanteA, contrincanteB):
    retoA=0
    retoB=0
    retosGanadosA=0
    retosGanadosB=0
    contador=0
    for i in range(len(contrincanteA)):
        
        retoA+=contrincanteA[i]
        retoB+=contrincanteB[i]
        contador+=1
        
        
        if contador==3:
            if retoA>retoB:
                retosGanadosA+=1
                retoA=0
                retoB=0
                contador=0
            elif retoB>retoA:
                retosGanadosB+=1
                retoA=0
                retoB=0
                contador=0
        
    if retosGanadosA>retosGanadosB:
        partida="El jugador A ha ganado la partida con un total de " +str(retosGanadosA) + " retos ganados"
    elif retosGanadosB < retosGanadosA:
        partida="El jugador B ha ganado la partida con un total de " +str(retosGanadosB) + " retos ganados"
    else:
        partida="Han quedado empate, con un total de "+str(retosGanadosA)+" retos ganados cada uno"
    return partida
print(contaRetos([1,1,4000,75,1000,12], [90,50,3000,41,0,70]))
print(contaRetos([1,1,2000,75,1000,12], [90,50,3000,41,0,70]))
print(contaRetos([1,1,4000,75,1000,12], [90,50,5000,41,4000]))
 
#Con esta funcion pido que se introduzcan las puntuaciones de cada desafio
def puntuador():
    contrincanteA=[]
    contrincanteB=[]
    retos=int(input("Cuantos retos quiere introducir"))
    i=0
    while i<retos*3:
        contrincanteA.append(int(input("introduce la puntuacion de este reto de A")))
        contrincanteB.append(int(input("introduce la puntuacion de este reto de B")))
        i+=1
    return contrincanteA, contrincanteB
        
    
print(puntuador())    
    
