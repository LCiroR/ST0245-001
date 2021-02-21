package Taller__4;

*@autorBrigith Giraldo, Luisa Ciro
*@version 1
*/
import java.util.Random;
public class taller4 {
    public static void main(String[] String) {
        int size = 20;
        int max = 20;
        int[] array = new int[size];
        System.out.println("ArrayMax");
        for (int a = 0; a < size; a++) {
            Random generator = new Random();
            array[a] = generator.nextInt(max);
            long inicio = System.currentTimeMillis();
            System.out.println(arrayMax(array, a, a));
            long fin = System.currentTimeMillis();
            long total = fin - inicio;
            System.out.println("el tiempo total fue de: " + total + " ms");
        }
        
        int tamaño = 20;
        int maximo = 20;
        int[] arreglo = new int[tamaño];
        System.out.println("groumpSum");
        for (int j = 0; j < tamaño; j++) {
            Random generator = new Random();
            array[j] = generator.nextInt(maximo);
            long inicio = System.currentTimeMillis();
            System.out.println(groupSum(j, arreglo, j));
            long fin = System.currentTimeMillis();
            long total = fin - inicio;
            System.out.println("El tiempo total fue de: " + total + " ms");
        }
        
        System.out.println("fibonacci");
        for (int i = 1; i <= 20; i++) {
            long inicio = System.currentTimeMillis();
            System.out.println(fibonacci(i));
            long fin = System.currentTimeMillis();
            long total = fin - inicio;
            System.out.println("El tiempo total fue de: " + total + " ms");
        } 

    }

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] array, int i, int j) {
        int med, max_left, max_right;
        if (i == j) { 
            return array[i];
        } else {
             med = (i + j) / 2;
                     max_left = arrayMax(array, i, med); 
                     max_right = arrayMax(array, med + 1, j); 
                     if (max_left > max_right){  
                 return max_left;
             } else {
                 return max_right;  
                   }
       
        }
}


    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param target es la meta, el numero que debe alacanzar la suma
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return groupSum(start + 1, nums, target - nums[start])
                || groupSum(start + 1, nums, target);

    }
    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */

    public static int fibonacci(int n){

        if (n <= 1) { 
            return n; 
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
