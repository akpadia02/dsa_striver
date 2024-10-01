class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int a=nums[i];
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==a){
                    count++;
                }
            }
            if(count==1){
                return a;
            }
        }
        return -1;
    }
}

//O(N^2)=TC
//O(N)=SC


import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the number that appears only once
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        
        return -1; // Fallback in case there is no single number
    }
}
