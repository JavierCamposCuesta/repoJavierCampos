'''
Realizar una función que busque una palabra escondida dentro de un texto. Por ejemplo, si la cadena es “shybaoxlna” 
y la palabra que queremos buscar es “hola”, entonces si se encontrará y deberá devolver True, en caso contrario deberá 
devolver False
Created on 27 Nov 2020

@author: estudiante
'''
def buscaTexto(cadena, palabra):
    c=0
    for i in cadena:
        if c <len(palabra) and i == palabra[c]:
            c+=1
    if c == len(palabra):
        print("La palabra se encuentra escondida")
        
buscaTexto("shycbacocalrnacaoladfs", "caracola")
            
            
        
    