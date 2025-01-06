import java.util.*;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n=ransomNote.length();
        int m=magazine.length();
        Hashtable<Character,Integer> t=new Hashtable<>();
        for(int i=0;i<m;i++){
            char c=magazine.charAt(i);
            t.put(c,t.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            char c=ransomNote.charAt(i);
            if(!t.containsKey(c) || t.get(c) == 0){
                return false;
            }else{
                t.put(c, t.get(c) - 1);
            }
        }
        return true;
    }
}


//freq
import java.util.*;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }
        return true;
    }
}