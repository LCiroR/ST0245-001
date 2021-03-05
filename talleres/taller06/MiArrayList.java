import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Brigith Giraldo, Luisa Ciro
 * @version 1
 */

 public class MiArrayList {
     private int size;
     private static final int DEFAULT_CAPACITY = 10;
     private int elements[]; 
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
     public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     
    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e, int index) {
        if (size == elements.length){
           int[] nuevo = new int[elements.length*2];
           for (int i = elements.length; i >= index; i--) // O(n)
              elements[i+1] = elements[i];  // O(n)
           elements = nuevo;
        }
        elements[size] = e;
        size = size + 1;
    }    // T(n) es O(n) en el peor caso, que es cuando está lleno
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) {
	if (i < size && i > 0) {
	    return elements[i];
	}else {
	    throw new IndexOutOfBoundsException("Index : " + i);
	}
    }

    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add2(int index, int e) {
	if ( index < size && index >= 0) {
	    for (int i = 0; i <= size; i++) { 
		if (i == size && size == elements.length) {
		    extend();
		}          
		if (i == index) {
		    int swap = elements[i] ;
		    elements[i] = e;
		    elements[i + 1] = swap;
		    i++;
		    size++;
		}
	    }
	}else if ( index == size ) {
	    elements[index] = e;
	    size++;
	    if (size == elements.length) {
		extend();
	    }
	}
    }

    private void extend() {
        int [] elements2 =  new int[elements.length + elements.length];
        for (int i = 0; i < size; i++) {
            elements2[i] = elements[i];
        }
        elements = elements2;
    }
    
    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        elements[index] = 0;
        for(int i = index; i < size; i++){
            int swap = elements[i];
            elements[i] = elements[i+1];
            elements[i+1] = swap;
        }
    }
}
