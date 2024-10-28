//Brute O(n1+n2)
public class Solution {
    public static double median(int[] nums1, int[] nums2) {
    	// Write your code here.
        int n1=nums1.length;
        int n2=nums2.length;
        double[] nums3=new double[n1+n2];
        int i=0,j=0,k=0;
        int n=n1+n2;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                nums3[k++]=nums1[i++];
            }else{
                nums3[k++]=nums2[j++];
            }
        }
        while(i<n1){
            nums3[k++]=nums1[i++];
        }
        while(j<n2){
           nums3[k++]=nums2[j++];
        }
        if(n%2==1){
            return nums3[n/2];
        }else{
            return (nums3[n/2]+nums3[(n/2)-1])/2;
        }
    }
}

//BS O(log(min(n1,n2)))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; 
    }
}