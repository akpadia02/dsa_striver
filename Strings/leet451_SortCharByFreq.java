import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        Hashtable<Character,Integer> t=new Hashtable<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            t.put(c,t.getOrDefault(c,0)+1);
        }
        while(!t.isEmpty()){
            char maxChar = '\0';
            int maxFreq=0;
            for (char key : t.keySet()) {
                if (t.get(key) > maxFreq) {
                    maxFreq = t.get(key);
                    maxChar = key;
                }
            }
            for (int i = 0; i < maxFreq; i++) {
                result.append(maxChar);
            }
            t.remove(maxChar);
        }
        return result.toString();
    }
}