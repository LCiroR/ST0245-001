/**
* Consider the leftmost and righmost appearances of some value in an array.
* We'll say that the "span" is the number of elements between the two inclusive
* Returns the largest span found in the given array.
*/
public int maxSpan(int[] nums) {
  int cont = 0;
  if(nums.length == 0) {
    return 0;
  }
  if(nums[0] != nums[nums.length - 1]) {
    for(int i = 1; i < nums.length; i++) {
      cont++;
    }
  }
  if(nums[0] == nums[nums.length - 1]) {
    for(int i = 0; i < nums.length; i++) {
      cont++;
    }
  }
  return cont;
}
