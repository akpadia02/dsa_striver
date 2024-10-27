//Same apporach as Allocate books
//bs O(N * log(sum(arr[])-max(arr[])+1))

class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int low = Integer.MIN_VALUE; 
        int high=0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low<=high){
            int mid=(low+high)/2;
            int count=f(nums,mid);
            if(count>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public int f(int[] nums,int i){
        int k=1;
        int n=nums.length;
        int summ=0;
        for(int j=0;j<n;j++){
            if(summ+nums[j]<=i){
                summ+=nums[j];
            }else{
                k++;
                summ=nums[j];
            }
        }
        return k;
    }
}