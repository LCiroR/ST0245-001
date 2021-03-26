import java.util.LinkedList;
public class Polaca {
    public static void main(String[] args) {
    }
    // 
    public static double calculadora(String[] exp) {
        LinkedList<Integer> pila = new LinkedList();
        String operadores = "+-*/";
        for (String elemento : exp)
          if (operadores.contains(elemento)){
            int operando2 = pila.pop();
            int operando1 = pila.pop();
            if (exp.equals("+"))
              pila.push(operando1 + operando2); 
          }         
          else // es un numero
              pila.push(Integer.valueOf(elemento));
        return pila.pop();
    }
}
