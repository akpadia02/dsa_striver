class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1}; 
        result[0] = findFirstPos(nums, target);
        result[1] = findLastPos(nums, target);
        return result;
    }
    public int findFirstPos(int[] nums,int target){
        int low=0;
        int n=nums.length;
        int high=n-1;
        int firstPos = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                firstPos=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return firstPos;

    }


    public int findLastPos(int[] nums,int target){
        int low=0;
        int n=nums.length;
        int high=n-1;
        int lastPos=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                lastPos=mid;
                low=mid+1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return lastPos;
    }
}


//or
// int lb=lowerBound(arr,x,k);
// if(lb==n || arr[lb]!=x) return {-1,-1};
// return {lb,upperBound(arr,x,k)-1};