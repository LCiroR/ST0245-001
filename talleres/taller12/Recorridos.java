public class Recorridos{
 public static boolean hayCaminoDFS(Graph g, int i, int f){
   return hayCaminoDFS(g, i, f, new boolean[g.size()]);
}
 private static boolean hayCaminoDFS(Graph g, int i, int f, boolean[] v){
   v[i] = true;
   if (i == f)
     return true;
   //else
   for (Integer hijito : g.getSuccessors(i))
      if (v[hijito] == false) // Si estas visitado, no llames recursivamente
        if (hayCaminoDFS(g,hijito,f,v))
            return true;
   return false; // Si nunca es verdadero o si no tiene hijos, da falso
 } 
 public static void main(String[] args){
   Graph g = new DigraphAM(5);
   System.out.println(hayCaminoDFS(g, 0, 3));
 }
}
