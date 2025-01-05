import java.util.Hashtable;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
           if (table.containsKey(nums[i])) {
                int prevIndex = table.get(nums[i]);
                if (Math.abs(i - prevIndex) <= k) {
                    return true; 
                }
            }
            table.put(nums[i], i); 
        }
        return false;
    }
}