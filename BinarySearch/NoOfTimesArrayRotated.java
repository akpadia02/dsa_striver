public class Solution {
    public static int findKRotation(int []nums){
        // Write your code here.
        int low=0;
        int n=nums.length;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(nums[low]<=nums[mid]){
                if(nums[low]<min){
                    index=low;
                    min=nums[low];
                }
                low=mid+1;
            }else{
                if(nums[mid]<min){
                    index=mid;
                    min=nums[mid];
                }
                high=mid-1;
            }
        }
        return index;
    }
}






public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        int n = arr.length; 
        int ans = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
                index = i;
            }
        }
        return index;
    }
}