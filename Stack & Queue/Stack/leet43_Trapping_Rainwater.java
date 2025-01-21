class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefixMax=new int[n];
        int[] suffixMax=new int[n];
        
        prefixMax[0]=height[0];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
        }

        suffixMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(suffixMax[i+1],height[i]);
        }

        int total=0;
        for(int i=0;i<n;i++){
            int leftMax=prefixMax[i];
            int rightMax=suffixMax[i];
            if(height[i]<leftMax && height[i]<rightMax){
                total+=Math.min(leftMax,rightMax)-height[i];
            }
        }
        return total;
    }
}