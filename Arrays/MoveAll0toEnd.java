class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                arr[index]=nums[i];
                index++;
            }
        }
        for(int i=index;i<n;i++){
            arr[i]=0;
        }
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}

//[1,3,0,8,0,9]=[1,3,8,9,0,0]

//optimal two pointer
class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return;
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums,i,j);
                j++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}