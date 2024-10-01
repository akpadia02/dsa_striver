public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        // Write your code here
        int n = a.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {

                sum = sum + a[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
//O(N^2)

//BETTER Hashing
//for negatives its optimal code
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        HashMap<Long,Integer> prefixSum=new HashMap<>();
        int len=0;
        long sum=0;
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(sum==K){
                len=i+1;
            }
            long rem=sum-K;
            if(prefixSum.containsKey(rem)){
                int l=i-prefixSum.get(rem);
                len=Math.max(len,l);
            }
            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }
        }
        return len;
        
    }
}
//O(N)

//positives optimal two pointer
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        int left=0,right=0;
        long sum=A[0];
        int len=0;
        while(right<N){
            while(sum>K && left<=right){
                sum-=A[left];
                left++;
            }
            if(sum==K){
                len=Math.max(len,right-left+1);
            }
            right++;
            if(right<N){
                sum+=A[right];
            }
        }
        return len;
    }
}