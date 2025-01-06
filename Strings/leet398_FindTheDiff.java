import java.util.*;
class Solution {
    public char findTheDifference(String s, String t) {
        Hashtable<Character,Integer> table=new Hashtable<>();
        int n=s.length();
        int m=t.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            table.put(ch,table.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            if(!table.containsKey(ch) || table.get(ch) == 0){
                return ch;
            }else{
                table.put(ch, table.get(ch) - 1);
            }
        }
        return '\0';
    }
}


//xor
import java.util.*;
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }
}



//hashset
import java.util.*;
class Solution {
    public char findTheDifference(String s, String t) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.iterator().next();
    }
}