import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;
import java.util.HashMap;

class ArchivosyTablas{
 public static void main(String[] args) throws IOException {
   Path ruta = Paths.get("usda-dc-directory.csv"); // Nada de C: D:
   String texto_del_archivo = Files.readString(ruta, StandardCharsets.UTF_8);
   // Nunca usar Scanner
   String[] lineas_del_texto_del_archivo = texto_del_archivo.split("\n"); 
   HashMap<String, String> tabla_de_hash = new HashMap<String, String>();
   for (String linea : lineas_del_texto_del_archivo){
       String[] columnas = linea.split(",");
       String apellido = columnas[0];
       String nombre = columnas[1];
       String telefono = columnas[3];
       tabla_de_hash.put(nombre+" "+apellido, telefono);
   }
   for (String nombre_y_apellido : tabla_de_hash.keySet())
       System.out.println(nombre_y_apellido + " " + tabla_de_hash.get(nombre_y_apellido));
 }     
}
