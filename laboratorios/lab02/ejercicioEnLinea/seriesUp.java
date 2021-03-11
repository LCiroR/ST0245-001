/**
* Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}
**/
public int[] seriesUp(int n) {
    int[] array = new int[n*(n+1)/2];
    int index = 0;
    for(int i = 1; i <= n; i++) {
        for(int j = 0; j < i; j++) {
            array[index + j] = j + 1;
        }
        index += i;
    }
    return array;
}
