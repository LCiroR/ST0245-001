import java.util.Arrays;

public class Laboratorio2{
    // Sorts an array using Insertion Sort
    public static void InsertionSort(int[] A){
       int temp,j;
       Arrays.toString(generarArreglo(50));
       for (int i = 0; i < A.length; i++){
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
       //System.out.println(Arrays.toString(A));
    }

      // Sorts an array using Merge Sort
      // Taken from www.cs.cmu.edu/
    public static void mergeSort(int [ ] a){
        int[] temp = new int[a.length];
        mergeSort(a, temp,  0,  a.length - 1);
        //System.out.println(Arrays.toString(a));
    }


    private static void mergeSort(int [ ] a, int [ ] temp, int left, int right){
        if( left < right ){
            int center = (left + right) / 2;
            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);
            merge(a, temp, left, center + 1, right);
        }
    }


    private static void merge(int[ ] a, int[ ] temp, int left, int right, int rightEnd ){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                temp[k++] = a[left++];
            else
                temp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            temp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            temp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = temp[rightEnd];
        
        
    }
  
    public static void main(String[] args){
        //test
         /*int[] A = {1,5,3,2,6};
         int[] B = {1,5,3,2};
         int[] C = {1,5,2,6};
         int[][] Arrays = {A,B,C};  
         for (int[] X : Arrays)
         {        
             Laboratory1.mergeSort(X);
             Laboratory1.InsertionSort(X);     
            }
          */
        for(int n = 50000; n <= 250000; n = n + 10000){
            int[] arreglo = new int[n];
            System.out.println(n);  
            arreglo = generarArreglo(n);
            long ti = System.currentTimeMillis();
            Laboratorio2.InsertionSort(arreglo);
            long tf = System.currentTimeMillis();
            System.out.println("El tiempo en ms de insertSort: "+(tf - ti));
        }

        for(int n = 5000000; n <= 25000000; n = n + 1000000){
            int[] arreglo = new int[n];
            System.out.println(n);
            arreglo = generarArreglo(n);
            long ti = System.currentTimeMillis();
            Laboratorio2.mergeSort(arreglo);
            long tf = System.currentTimeMillis();
            System.out.println("El tiempo en ms margeSort: "+(tf - ti));
        }
  
    }
    
    public static int [] generarArreglo(int n) {
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round(Math.random()*10);
        }
        return arr;
    }
}
