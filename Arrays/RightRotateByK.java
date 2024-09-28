//brute
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int[] arr=new int[n];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[n - k + i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[k + i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
        System.out.println(Arrays.toString(nums));

        
    }
}

//O(K+N)

//Optimal
class Solution {
    public void rotate(int[] nums, int k) {
        // if (n == 0 || k % n == 0) {
        //     return;
        // }
        int n=nums.length;
        k = k % n;
        reverse(0,nums,n-1-k);
        reverse(n-k,nums,n-1);
        reverse(0,nums,n-1);

    }

    public static void reverse(int i,int[] arr,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}