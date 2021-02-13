import os

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
    path_directorio_archivos = 'C:/Users/LFCIR/OneDrive/Documentos/ST0245-001/proyecto/datasets/archivosCSV/ganado enfermo CSVs'
    imagenes = []
    
    directorio = os.fsencode(path_directorio_archivos)

    for archivo in os.listdir(directorio):
        nombre_archivo = os.fsdecode(archivo)
        path_archivo = path_directorio_archivos + '/' + nombre_archivo
        imagen = leer_archivo(path_archivo)
        imagenes.append(imagen)

    print('Se leyeron {0} imagenes'.format(len(imagenes)))


if __name__ == "__main__":
    main()