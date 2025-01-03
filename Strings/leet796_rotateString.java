class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubleS = s + s;
        return doubleS.contains(goal);
    }
}