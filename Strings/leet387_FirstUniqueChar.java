import java.util.Hashtable;
class Solution {
    public int firstUniqChar(String s) {
       Hashtable<Character,Integer> t=new Hashtable<>(); 
       int n=s.length();
       for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            t.put(c, t.getOrDefault(c, 0) + 1);
        }
       for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if (t.get(c) == 1) {
                return i;
            }
       }
       return -1;
    }
}