//linear O(N*Max)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        for(int i=1;i<=max;i++){
            int a=f(nums,i);
            if(a<=threshold){
                return i;
            }
        }
        return -1;
    }
    public int f(int[] nums,int i){
        int n=nums.length;
        int ans=0;
        for(int j=0;j<n;j++){
            ans+=Math.ceil((double)nums[j]/i);
        }
        return ans;
    }
}

//BS O(N*Log(max))

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+((high-low)/2);
            int a=f(nums,mid);
            if(a<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int f(int[] nums,int i){
        int n=nums.length;
        int ans=0;
        for(int j=0;j<n;j++){
            ans+=Math.ceil((double)nums[j]/i);
        }
        return ans;
    }
}