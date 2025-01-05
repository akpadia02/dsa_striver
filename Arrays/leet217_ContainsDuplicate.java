import java.util.Hashtable;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        for (int num : nums) {
            if (table.containsKey(num)) {
                return true; // Duplicate found
            }
            table.put(num, true); // Mark the number as seen
        }
        return false; 
    }
}