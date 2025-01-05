import java.util.Hashtable;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n=pattern.length();
        String[] words = s.split(" ");
        if (n != words.length) {
            return false;
        }
        Hashtable<Character,String> table=new Hashtable<>();
        for(int i=0;i<n;i++){
            if(table.containsKey(pattern.charAt(i))){
                if(!table.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }else{
                if(table.containsValue(words[i])){
                    return false;
                }else{
                    table.put(pattern.charAt(i),words[i]);
                }
            }
        }
        return true;
    }
}