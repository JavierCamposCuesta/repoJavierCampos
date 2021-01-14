'''En el gimnasio Jacatfitness para el que ya hemos trabajado nos piden que realicemos un programa para determinar si deberías 
acudir al médico para que te haga una revisión, para ello debemos hacer las siguientes preguntas:

            ¿Peso?
            ¿Edad?
            ¿Tipo de vida? (Sedentaria/Activa/Muy activa)

El programa terminará si se introduce un peso negativo. Se deben comprobar que los datos son correctos y si no lo son, se deben 
volver a preguntar. Las recomendaciones para ir al médico son:

        Si tienes más de 70 años y lleva una vida Sedentaria
        Si pesa más de 100 kg sea cual sea la edad.
        Si pesa más de 74,4 kg y tiene más de 50 años

En cualquier otro caso se mostrará “No es urgente que acuda al médico si no tiene problemas de salud”
Created on 4 Nov 2020

@author: Javier Campos
'''
fin=0
while fin==0:
    peso=float(input("Introduce  tu peso (negativo para terminar) = "))
    if peso>=0:
        edad=int(input("Introduce tu edad= "))
        if edad >0:
            vida=input("Introduce tu  tipo de vida (sedentaria / activa / muy activa: ")
            vida=vida.lower()
            if peso>100 or (edad>70 and vida==str("sedentaria") or (peso > 74.4 and edad >50)):
                print("Deberia acudir al medico")
            elif vida==str("sedentaria") or vida==str("activa") or vida==("muy activa"):
                print("No es necesario que acuda al medico")
            else:
                print("El estilo de vida introducido no es correcto")
        else:
            print("La edad introducida no es valida")
    else:
        print("Fin")
        fin=1
