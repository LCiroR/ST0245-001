  
import os
import pandas as pd
import numpy as np
import cv2


imagenes_escaladas = []


def leer_archivo(path_archivo):
    """
        Recibe el path del archivo csv (string).
        retorna la matriz que representa el archivo.
    """
    matriz = []

    with open(path_archivo, 'r') as f:
        filas = f.readlines()
        
        for fila in filas:
            fila = fila.strip() 
            fila = fila.split(',') 
            fila = [int(x) for x in fila]
            matriz.append(fila)

    return matriz


def main():
    path_directorio_archivos = 'C:/Users/LFCIR/Documents/ST0245-001/proyecto/datasets/archivosCSV/ganado enfermo CSVs'  

    
    directorio = os.fsencode(path_directorio_archivos)

    for archivo in os.listdir(directorio):
        nombre_archivo = os.fsdecode(archivo)
        path_archivo = path_directorio_archivos + '/' + nombre_archivo
        imagen = leer_archivo(path_archivo)
        imagen = np.uint8(imagen)
        cv2.imshow('original', imagen)
        imagen_escalada = cv2.resize(imagen, (0, 0), fx=0.5, fy=0.5, interpolation=cv2.INTER_NEAREST)
        cv2.imshow('escalada', imagen_escalada)

        cv2.waitKey()

        
        imagenes_escaladas.append(imagen_escalada)

def descomprimir():
    path_directorio_archivos = 'C:/Users/LFCIR/Documents/ST0245-001/proyecto/datasets/archivosCSV/ganado enfermo CSVs'  
    
    directorio = os.fsencode(path_directorio_archivos)

    for archivo in os.listdir(directorio):
        nombre_archivo = os.fsdecode(archivo) + ".csv"
        
    for imagen_escalada in imagenes_escaladas:
        imagen_des= cv2.resize(imagen_escalada, (0, 0), fx=2, fy=2, interpolation=cv2.INTER_NEAREST)
        imagen_descsv = np.savetxt(nombre_archivo, imagen_des , fmt = '%s', delimiter=',') 
        
        print(imagen_descsv)


if __name__ == "__main__":
    main()
    descomprimir()