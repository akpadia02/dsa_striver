//rotate array by one place
//[1,2,3,4]=[2,3,4,1]

public void rotateLeftByOne(int[] arr) {
    int temp = arr[0];
    int n = arr.length;

    for (int i = 1; i < n; i++) {
        arr[i-1] = arr[i];
    }
    arr[n-1] = temp;
}

//O(N)