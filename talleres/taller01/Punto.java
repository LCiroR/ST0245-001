/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 * 
* @author Luisa Ciro, Brigith Giraldo
 * @version 1
 */
import java.lang.Math;
public class Punto {

    private double x, y;

    /**
     * Se inicializan los atributos de clase
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;

    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
        return x;

    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
        return y;

    }

    /**
     * Método para obtener el radio polar, en este caso se puede obtener por medio del teorema de pitágoras.
     * @return radio polar
     */
    
    public double radioPolar() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

    }


    /**
     * Método para obtener el ángulo polar, en este caso se puede obtener por medio de la tangente inversa.
     * 
     *
     * @return angulo polar
     */
    public double anguloPolar() {
        return Math.atan(y/x);

    }

    /**
     * Método para obtener la distacia euclidiana. La distacia
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado
     */
  
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow(otro.x() - x, 2) + Math.pow(otro.y() - y, 2));
    } 
}