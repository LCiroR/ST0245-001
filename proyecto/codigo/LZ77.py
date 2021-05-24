import pandas as pd
import numpy as np
import cv2
import os

path_directorio_archivos = 'C:/Users/LFCIR/Desktop/test/imag'  
directorio = os.fsencode(path_directorio_archivos)

for archivo in os.listdir(directorio):
    nombre_archivo = os.fsdecode(archivo)
    path_archivo = path_directorio_archivos + '/' + nombre_archivo
    csv = open(path_archivo)


    #La variable pasa el archivo de csv a texto 
    csvTexto = ' '.join([i for i in csv])


    #Parte compresión
    tamaño = 0 
    #Tamaño de la ventana
    win = 10 
    #indicador de la primera posicion
    indicador = 0
    texto = csvTexto
    texto_compr = list() 
    while True:
        if indicador - win < 0:
            match = texto[0:indicador]
        else:
            match = texto[indicador - win:indicador]
        while match.find(texto[indicador:indicador + tamaño + 1]) != -1:
            tamaño += 1
        first = match.find(texto[indicador:indicador + tamaño])
        if indicador - win > 0:
            first += indicador - win
        if tamaño != 0:
            a = (indicador - first, tamaño, texto[indicador + tamaño])
            texto_compr.append(a)
            indicador += tamaño + 1
        else:
            b = (0,0,texto[indicador])
            texto_compr.append(b)
            indicador +=1
        tamaño = 0
        if indicador == len(texto):
            break

    #Parte descompresion
    texto_desc = ""
    for s in texto_compr:
        if s[0] != 0:
            texto_desc += texto_desc[(len(texto_desc) - s[0]): (len(texto_desc) - s[0] + s[1])]
        texto_desc += s[2]


    #Se convierte el texto comprimido a archivo csv
    f = open('nuevocsv.csv', 'w')
    f.write(texto_desc) 
    f.close()

    #Se convierte el archivo csv a dataframe, luego a un Array y por último se genera la imagen
    df = pd.read_csv('nuevocsv.csv')
    np_array = df.to_numpy()
    cv2.imwrite(nombre_archivo + ".png", np_array)