public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low=0;
        int high=n-1;
        return BS(arr,low,high,x,n);
    }
    public static int BS(int[] arr,int low,int high,int x,int ans){
        if(low>high){
            return ans;
        }
        int mid=(low+high)/2;
        if(arr[mid]>=x){
            ans=mid;
            return BS(arr,low,mid-1,x,ans);
        }else{
            return BS(arr,mid+1,high,x,ans);
        }
    }
}


//floor Floor of x is defined as the largest element k in arr[] such that k is smaller than or equal to x.
class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<x){
                ans=mid;
                low=mid+1;
            }else if(arr[mid]==x){
                return mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}

//O(LogN)