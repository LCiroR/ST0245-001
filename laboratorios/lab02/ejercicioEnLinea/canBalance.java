/**
* Given a non-empty array, return true if there is a place to split the array 
* so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
**/
public boolean canBalance(int[] nums) {
  int prim = 0;
  int seg = 0;
      
  for(int i = 0; i < nums.length; i++){
    seg += nums[i];
  }
  for(int i = 0; i <= nums.length - 2; i++) {
    prim += nums[i];
    seg -= nums[i];
    if(prim == seg){
      return true;
    }
  }
  return false;
}
