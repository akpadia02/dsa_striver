class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[low]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[high]>=target && target>=nums[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}

//O(LogN)