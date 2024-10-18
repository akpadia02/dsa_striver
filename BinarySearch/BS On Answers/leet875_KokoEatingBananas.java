//linear  O(max(arr)*n) tle
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        for(int i=1;i<=max;i++){
            int t=f(piles,i);
            if(t<=h){
                return i;
            }
        }
        return -1;
    }

    public int f(int piles[],int hourly){
        int total=0;
        int n=piles.length;
        for(int i=1;i<n;i++){
            total += Math.ceil((double) piles[i] / hourly);
        }
        return total;
    }
}

//BS  O(nLog(max))
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int t=f(piles,mid);
            if(t<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int f(int piles[],int hourly){
        int total=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            total += Math.ceil((double) piles[i] / hourly);
        }
        return total;
    }
}