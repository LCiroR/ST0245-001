 /**
 * La clase Taller5 tiene la intención de resolver el taller número 5.
 *
 * @author Brigith Giraldo, Luisa Ciro 
 * @version 1
 */
import java.util.Arrays;
import java.util.Random;

public class Taller5{  
    public static void main(String[] String) { 
        int size = 60;
        int max = 70;
        int[] array;
        for (int a = 40; a < size; a++) {
            array = generarArreglo(size);
            long inicio = System.currentTimeMillis();
            System.out.println(suma(array));
            long fin = System.currentTimeMillis();
            long total = fin - inicio;
            System.out.println("El tiempo fue de: " + total + " ms");
        }
        
        int[] arr = new int[size];
        for (int a = 40; a < size; a++) {
            Random generator = new Random();
            arr[a] = generator.nextInt(max);
            long inicio = System.currentTimeMillis();
            System.out.println(Arrays.toString(arr));
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
            long fin = System.currentTimeMillis();
            long total = fin - inicio;
            System.out.println("El tiempo fue de: " + total + " ms");

        }
    }

    
    /**
    * @param array es una arreglo de numeros enteros.
    * El método suma tiene la intención de hacer el proceso de suma
    * mediante una funcion cíclica (while/for/...)
    * @return la suma de todos los numeros sumados.
    */
    public static int suma (int[]array){
        int suma = 0; //C1 es O(1)
        for(int i = 0; i < array.length; i++){ // C2 + C3*n es O(n)
            suma+= array[i]; //C4 + C5*n es O(n)
        }
        return suma; //C5 es O(1)
        //t(n)=O(1)+O(n)+O(n)+O(1)= O(n)
    }
    
    /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención ordenar los números
    * del arreglo array por el método insertion:
    * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
    * mediante la anidación de funciones cíclicas (while/for/...)
    * 
    */
    public static void insertionSort (int[] array){
        int n = array.length; // C1 es O(1)
            for (int i=1; i<n; ++i){ // C2 + C3*n es O(n)
            int key = array[i]; // C4*n es O(n)
            int j = i-1; // C5*n es O(n)
            while (j>=0 && array[j] > key){ // 1 + 2 + 3 + 4 + 5 + .. n = n(n+1)/2 es O(n*n)
            
                array[j+1] = array[j]; // 1 + 2 + 3 + 4 + 5 + .. n = n(n+1)/2 es O(n*n)
                j = j-1; // 1 + 2 + 3 + 4 + 5 + .. n = n(n+1)/2 = n*n/2 + n/2 es O(n*n)
            }// n*n/2 + n/2 es O(n*n/2 + n/2) es O(n*n/2) es O(n*n)
            array[j+1] = key; // C6*n es O(n), por regla del producto O(c.f) = O(f)
        }
        // T(n) = O(1) + O(n) + O(n*n) = O(n*n)
    }

    public static int[] generarArreglo(int size) {
    int [] arr = new int[size];
    for (int i = 0; i < size; i++) {
            arr[i] = (int) Math.round(Math.random());
        }
    return arr;
    }
}
