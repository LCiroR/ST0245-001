public int maxMirror(int[] nums) {
  int cont = 0;
  int max = 0;
  for (int i = 0; i < nums.length; i++){
    int x = i;
    for (int j = nums.length - 1; j >= 0; j--){
      while (x < nums.length && j >= 0 && nums[x] == nums[j]){
        x++;
        j--;
        cont++;
      }
    max = Math.max(cont, max);
    cont = 0;
    }
  }
  return max;
}
