package Taller__4;

*@autorBrigith Giraldo, Luisa Ciro
*@version 1
*/
public class Taller4 {
    
    
    /**
	* @param array es un arreglo de numeros enteros
	* @param i primera posicion del arreglo
	* @param j ultima posicion del arreglo
	*
	*en este método se busca calcular el maximo de los elementos de un arreglo.
	*
	* @return el maximo
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
    
    /**
	* @param start es un contador, nos sirve para saber cuando debemos parar
	* @param array es un arreglo de numeros enteros, representan volumen
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
        //...
    }
	
	
	/**
	* @param n numero entero, hasta que numero se hace la serie
	*
	* el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
	* @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
	* @return el valor encontrado en long dada la posible cantidad de bits
	*/
	public static long fibonacci(int n) { 
		if (n == 0){
			return 0;
		}else if (n == 1){
			return 1;
		}else{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
