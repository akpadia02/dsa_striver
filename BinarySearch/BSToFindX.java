public class Solution {
    public static int search(int []nums, int target) {
        // Write your code here.
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}


//recursive approach
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        return BS(nums,low,high,target);
    }
    public static int BS(int[] nums,int low,int high,int target){
        if(low>high) return -1;
        int mid=low+((high-low)/2);
        if(nums[mid]==target){
            return mid;
        }else if(target>nums[mid]){
            return BS(nums,mid+1,high,target);
        }else{
            return BS(nums,low,mid-1,target);
        }
    }
}

//O(log(N))