/**
* Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
* except ignoring the largest and smallest values in the array
**/
public int centeredAverage(int[] nums) {
  int min = nums[0];
  int max = nums[0];
  int av = 0;
  for(int i = 0; i < nums.length; i++) {
    min = Math.min(min, nums[i]);
    max = Math.max(max, nums[i]);
    av += nums[i];
  }
  return (av - min - max)/ (nums.length - 2);
}
