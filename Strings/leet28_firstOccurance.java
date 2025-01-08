class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            int index=haystack.indexOf(needle);
            return index;
        }else{
            return -1;
        }
    }
}