'''
Created on 18 Dec 2020

@author: estudiante
'''
def convierteFecha(fecha):
    if not fecha[0]>0 or fecha[1]>12:
        print("error")
    elif not fecha[1]>0 or fecha[2]<60:
        print("error")
    elif fecha[2] != ":":
        print("error")
    elif fecha[3]:
        