import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @author Brigith Giraldo, Luisa Ciro
 */
public class Taller8 {
    
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca  (String string){
        String[] prefixStr = string.split(" "); 
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<prefixStr.length;i++){
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop()+stack.pop() );
            }
            else if(prefixStr[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(prefixStr[i].equals("-")){
                stack.push( stack.pop() -stack.pop());
            }
            else if(prefixStr[i].equals("/")){
                stack.push(stack.pop() / stack.pop());
            }
            else{
                stack.push(Integer.parseInt(prefixStr[i]));
            }
        }
        return stack.pop();
    }
	
    /**
    *

    *  posición de una pila si no que tambien devuelve su valor.
    * @return una pila que aga el inverso de sta ck
    */
    public static Stack<Integer> inversa (Stack<Integer>stack){
        int n = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        for(int i = 0; i < n; i++) 
            temp.get(stack.pop());
        return temp;
    }

    /* *
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola(Queue<String> queue){
        while (!queue.isEmpty())    
            System.out.println("Atendiendo a " + queue.poll());
    }
    

}
