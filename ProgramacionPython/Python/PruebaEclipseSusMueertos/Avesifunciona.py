'''
Created on 3 dic. 2020

@author: Javier
'''
c=25
c1=1
e=" "
a="*"
s="+"
for i in range (1,c+1):
    print((e*(c))+s*(c1))
    c-=1
    c1+=2
for i in range (1,5):
    print(e*int((c1/2)-2)+"|"*8)
    
    
    