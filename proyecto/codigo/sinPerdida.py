import pandas as pd
import cv2
import os
import time
inicio = time.time()

"""
Created on Friday May 22 16:54:20 2021

@author: Brigith Giraldo, Luisa Ciro
"""
#Algoritmo compresion y descompresion de imagenes usando el metodo de huffman

print ("Algoritmo compresion/descompresion huffman")
print ("---------------------------\n")

path_directorio_archivos = 'C:/Users/LFCIR/Desktop/test/imag'
directorio = os.fsencode(path_directorio_archivos)

for archivo in os.listdir(directorio):
    nombre_archivo = os.fsdecode(archivo)
    path_archivo = path_directorio_archivos + '/' + nombre_archivo
    
    #Se convierte el archivo csv a texto (string)
    string = open(path_archivo)
    string = ' '.join([i for i in string])
    len_string = len (string)
    print ("El archivo es de:", len_string * 8, "bits ")

    #Crear una lista de caracteres con su frecuencia, una lista solo de los caracteres
    caractrs = []
    solo_caractrs =[]
    for caractr in string:
        if caractr not in caractrs:
            freq = string.count(caractr)
            caractrs.append(freq)
            caractrs.append(caractr)
            solo_caractrs.append(caractr)
    print("Frecuencia de cada caracter:")
    print(caractrs)

    #generar los nodos base para huffma_tree, frecuencia y caracter
    nodos = []
    while len(caractrs)>0:
        nodos.append(caractrs[0:2])
        caractrs = caractrs[2:]
    nodos.sort()
    huffman_tree = []
    (huffman_tree.append(nodos))

    #combina de forma recursiva los nodos base para crear el árbol de huffman y asigna un 0 o un 1 a cada par de nodos antes de combinarlos
    #que luego se usarán para crear el código binario para cada caracter
    def combinar(nodos):
        pos = 0
        nuevonodo = []
        #obtiene dos nodos más abajo
        if len (nodos)>1:
            nodos.sort()
            #agrega el 0,1 para su uso futuro
            nodos[pos].append("0")
            nodos[pos+1].append("1")
            combinar_nodo1 = (nodos[pos][0]+nodos[pos+1][0])
            combinar_nodo2 = (nodos[pos][1]+nodos[pos+1][1])
            nuevonodo.append(combinar_nodo1)
            nuevonodo.append(combinar_nodo2)
            nuevosnodos = []
            nuevosnodos.append(nuevonodo)
            nuevosnodos = nuevosnodos + nodos[2:]
            nodos = nuevosnodos
            huffman_tree.append(nodos)
            combinar(nodos)
        return huffman_tree

    nuevosnodos = combinar(nodos)

    #El árbol debe invertirse: esto da una visualización (aproximada) de lo que podría hacer demostrándolo en un grafico
    huffman_tree.sort(reverse=True)

    #Elimina elementos duplicados en el árbol de huffman y crea una matriz (Checklist) con solo los nodos y el correcto.
    #El siguiente bloque es solo para visualizar e imprimir la matriz del árbol Huffman
    checklist = []
    for nivel in huffman_tree:
        for nodo in nivel:
            if nodo not in checklist:
                checklist.append(nodo)
            else:
                nivel.remove(nodo)
    count = 0

    #Construye los códigos binarios para cada carácter, fácil salida si solo hay 1 tipo de carácter en la cadena
    caractr_binary = []
    if len(solo_caractrs)==1:
        caractr_code = [solo_caractrs[0], "0"]
        caractr_binary.append(caractr_code*len(string))
    else:
        for caractr in solo_caractrs:
            caractrcode = ""
            for nodo in checklist:
                if len(nodo)>2 and caractr in nodo[1]:
                    caractrcode = caractrcode + nodo[2]
            caractr_code = [caractr, caractrcode]
            caractr_binary.append(caractr_code)

    #Imprime los caracteres con sus codigos binarios
    print("Los codigos binarios son los siguientes:")
    for caractr in caractr_binary:
        print (caractr[0], caractr[1])

    #Crea una cadena de bits del mensaje original usando los nuevos codigos que ha generado para cada letra
    bitstring = ""
    for character in string:
        for item in caractr_binary:
            if character in item:
                bitstring = bitstring + item[1]

    #Convertir la cadena en digitos binarios
    binary = ( (bin(int(bitstring, base=2))))

    #Resumen de la compresión de datos
    uncompressed_file_size = len(string)*8
    compressed_file_size = len(binary)
    print("EL archivo original tenia:", uncompressed_file_size, "bits. EL archivo comprimido tiene:", compressed_file_size,"bits")
    print("Esto es un ahorro de",uncompressed_file_size-compressed_file_size,"bits, con una tasa de compresion de:",uncompressed_file_size/compressed_file_size,": 1")

    #Muestra los datos comprimidos en una cadena de dígitos binarios
    #print("EL mensaje como binario es:")
    #print (binary)

    #Guarda la cadena de bits en un archivo
    listToStr = ' '.join([str(elem) for elem in binary])
    texto_comp = (listToStr)
    file_com = "arch_bitscomp"

    #Convierte el mensaje comprimido a archivo csv 
    f = open("arch_bitscomp.csv", 'w')
    f.write(texto_comp) 
    f.close()

    #Descompresion, usando el caractr_binary array (Diccionario de letras y códigos)
    #convierte binario a cadena
    bitstring = str(binary[2:])
    uncompressed_string = ""
    code = ""
    for digito in bitstring:
        code = code+digito
        pos = 0
        for caractr in caractr_binary:
            if code == caractr[1]:
                uncompressed_string = uncompressed_string+caractr_binary[pos][0]
                code = ""
            pos +=1

    #Convierte los datos que ha descomprimido a archivo csv
    f = open('nuevocsvdesc.csv', 'w')
    f.write(uncompressed_string) 
    f.close()

    #Convierte el archivo csv a dataframe, luego a un Array y por último se generá la imagen
    df = pd.read_csv('nuevocsvdesc.csv')
    np_array = df.to_numpy()
    #cv2.imwrite("newimg.png", np_array) 
    cv2.imwrite(nombre_archivo + ".png", np_array)

fin = time.time()
print("tiempo ejecucion:", fin-inicio)

