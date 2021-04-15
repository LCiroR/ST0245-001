import os
import pandas as pd
import numpy as np
import cv2

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
    imagenes = []
    imagenes_escaladas = []
    
    directorio = os.fsencode(path_directorio_archivos)

    for archivo in os.listdir(directorio):
        nombre_archivo = os.fsdecode(archivo)
        path_archivo = path_directorio_archivos + '/' + nombre_archivo
        imagen = leer_archivo(path_archivo)
        imagen = np.uint8(imagen)
        imagen_escalada = cv2.resize(imagen, (0, 0), fx=0.5, fy=0.5, interpolation=cv2.INTER_NEAREST)

        imagenes.append(imagen)
        imagenes_escaladas.append(imagen_escalada)


if __name__ == "__main__":
    main()
