/** 
* Return the number of even ints in the given array
**/
public int countEvens(int[] nums) {
  int sum = 0;
  for(int i = 0; i < nums.length; i++){
    if(nums[i] % 2 == 0){
      sum += 1;
    }
    continue;
  }
  return sum;
}
