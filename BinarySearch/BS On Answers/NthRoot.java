//linear
//O(mn)
public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int ans=-1;
        for(int i=1;i<=m;i++){
            if(f(i,n)==m){
                return i;
            }else if(f(i,n)>m){
                break;
            }
        }
        return -1;
    }

    public static int f(int i,int n){
        int result = 1;
        for (int j=0;j<n;j++) {
            result *= i;
        }
        return result;
    }
}