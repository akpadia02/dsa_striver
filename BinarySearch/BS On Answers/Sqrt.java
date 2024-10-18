//linear 
public class Solution {
	public static int sqrtN(long N) {
		 int ans=1;
		 for(int i=1;i<=N;i++){
			 if(i*i<=N){
				 ans=i;
			 }else{
				 break;
			 }
		 }
		 return ans;
	}
}

//O(log(N))
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long low=1;
		long high=n;
		long ans=1;
		while(low<=high){
			long mid=(low+high)/2;
			if(mid*mid<=n){
				ans=mid;
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return ans;
    }
}