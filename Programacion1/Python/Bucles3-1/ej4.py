'''
4.    Design a method called dayOfWeek that receives three integer parameters: day,
 month and year. The method should return a number between 0 and 6 that is the day in 
 the week for that date. You have to know the next algorithm:

a = (14 - month) / 12
y = year * a
m = month + 12 * a * 2
d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) mod 7

If the variable d is zero was Sunday, 1 Monday�����... 6 Saturday.

Created on 9 dic. 2020

@author: Javier
'''
def dayOfWeek():
    fin=0
    while fin==0:
        day=int(input("Introduce un dia: "))
        month=int(input("Introduce un mes: "))
        year=int(input("Introduce un year: "))
        if (day<=31 and day>=1) and (month>=1 and month<=12) and (year>=0):
            fin=1
            a = (14 - month) / 12
            y = year * a
            m = month + 12 * a * 2
            d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7
            print(d)
            d=round(d, 0)
            if d==1:
                print("Ese dia es lunes")
            elif d==2:
                print("Ese dia es martes")
            elif d==3:
                print("Ese dia es miercoles")
            elif d==4:
                print("Ese dia es jueves")
            elif d==5:
                print("Ese dia es viernes")
            elif d==6:
                print("Ese dia es sabado")
            elif d==0:
                print("Ese dia es domingo")
        else:
            print("Los datos introducidos no son validos")
dayOfWeek()
                
                
                
                
                
                