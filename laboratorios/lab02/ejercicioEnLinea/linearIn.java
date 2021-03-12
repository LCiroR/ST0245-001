/**
* Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer
**/
public boolean linearIn(int[] outer, int[] inner) {
  int i = 0;
  int j = 0;
   while(i < inner.length && j < outer.length){
     if(inner[i] < outer[j] || inner[i] > outer[j]){
       j++;
     } else {
       i++; 
     }
   }
   if(i == inner.length){
     return true;
   }
   return false;
}
