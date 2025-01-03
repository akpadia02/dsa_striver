class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder r=new StringBuilder();
        int index=0;
        
        while(true){
            if (index >= strs[0].length()) break;

            char first = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != first) {
                    return r.toString(); 
                }
            }
            r.append(first);
            index++;
        }
        return r.toString();
    }
}