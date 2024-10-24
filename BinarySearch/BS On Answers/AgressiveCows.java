//linear O(NlogN) + O(N *(max(stalls[])-min(stalls[]))),
import java.util.Arrays;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n=stalls.length;
        int max=stalls[n-1];
        int min=stalls[0];
        for(int i=1;i<=max-min;i++){
            if (!canWePlace(stalls, i, k)) {
                return i - 1;  
            }
        }
        return max-min;
    }

    public static boolean canWePlace(int[] stalls,int dist,int k){
        int countCows=1;
        int n=stalls.length;
        int last=stalls[0];
        for(int i=0;i<n;i++){
            if(stalls[i]-last>=dist){
                countCows++;
                last=stalls[i];
            }
        }
        if(countCows>=k){
            return true;
        }else{
            return false;
        }
    }
}

//BS  O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
import java.util.Arrays;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n=stalls.length;
        int max=stalls[n-1];
        int min=stalls[0];
        int low=0;
        int high=max-min;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(stalls, mid, k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static boolean canWePlace(int[] stalls,int dist,int k){
        int countCows=1;
        int n=stalls.length;
        int last=stalls[0];
        for(int i=0;i<n;i++){
            if(stalls[i]-last>=dist){
                countCows++;
                last=stalls[i];
            }
        }
        if(countCows>=k){
            return true;
        }else{
            return false;
        }
    }
}