//linear O(n*n*max)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int total=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,weights[i]);
            total+=weights[i];
        }
        int d=max+days;
        for(int i=max;i<=total;i++){
            int a=f(weights,i,days);
            if(a<=days){
                return i;
            }
        }
        return -1;
    }

    public int f(int[] weights,int i,int days){
        int ans=1;
        int sum=0;
        int n=weights.length;
        for(int j=0;j<n;j++){
            if(sum+weights[j]>i){
                ans++;
                sum=0;
            }
            sum+=weights[j];
        }
        return ans;
    }
}

//BS O(nlog(n*max))
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int total=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,weights[i]);
            total+=weights[i];
        }
        int low=max;
        int high=total;
        int ans=-1;
        while(low<=high){
            int mid=low+((high-low)/2);
            int a=f(weights,mid,days);
            if(a<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int f(int[] weights,int i,int days){
        int ans=1;
        int sum=0;
        int n=weights.length;
        for(int j=0;j<n;j++){
            if(sum+weights[j]>i){
                ans++;
                sum=0;
            }
            sum+=weights[j];
        }
        return ans;
    }
}