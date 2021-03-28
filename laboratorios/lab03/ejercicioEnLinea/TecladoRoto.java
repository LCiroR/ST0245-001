/**
 * Write a description of class n here.
 * 
 * @author (Brigith Giraldo, Luisa Ciro) 
 * @version 1
 */
import java.util.*;
public class TecladoRoto{
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        int cont = 0;
      
        for(char c : a.toCharArray()){
            if(c == '['){
                cont = 0;
            }else if(c == ']'){
                cont = texto.size();
            }else
                texto.add(cont++, c);
        }

        StringBuilder t = new StringBuilder();
        for(char l : texto)
            t.append(l);

            System.out.println(t.toString());
            return 0;
        }

    public static void main(String[] args) {
        String a = "[[a[[d[f[[g[g[h[h[dgd[fgsfa[f";
        System.out.println(teclado(a));
    }
}
