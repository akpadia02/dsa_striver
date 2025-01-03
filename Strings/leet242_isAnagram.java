class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m != n) {
            return false;
        } else {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++; 
                freq[t.charAt(i) - 'a']--; 
            }
            for (int count : freq) {
                if (count != 0) {
                    return false; 
                }
            }
            return true;
        }
    }
}