//linear O((max-min+1)*N)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int bouquets=0;
        for(int i=min;i<=max;i++){
            bouquets=f(bloomDay,i,m,k);
            if(bouquets>=m){
                return i;
            }
        }
        return -1;
    }

    public int f(int[] bloomDay,int day,int m,int k){
        int count=0,ans=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                ans+=count/k;
                count=0;
            }
        }
        ans+=count/k;
        return ans;
    }
}

//BS O(N*Log(max-min+1))
 class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int low=min;
        int high=max;
        int answer=-1;
        while(low<=high){
            int mid=low + (high - low) / 2;
            int b=possible(bloomDay,mid,m,k);
            if(b>=m){
                answer=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return answer;
    }

    public int possible(int[] bloomDay,int day,int m,int k){
        int count=0,ans=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                ans+=count/k;
                count=0;
            }
        }
        ans+=count/k;
        return ans;
    }
}