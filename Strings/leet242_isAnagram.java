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


//hashtable
import java.util.Hashtable;
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m != n) {
            return false;
        } else {
            Hashtable<Character,Integer> table=new Hashtable<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                table.put(c, table.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < m; i++) {
                char c = t.charAt(i);
                if (!table.containsKey(c)) {
                    return false;
                }
                table.put(c, table.get(c) - 1);
                if (table.get(c) == 0) {
                    table.remove(c); 
                }
        }
        return table.isEmpty();
        }
    }
}