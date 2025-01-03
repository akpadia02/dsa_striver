class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder r = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    r.append(ch);
                }
                count++;
            } else if (ch == ')') {
                count--;
                if (count > 0) {
                    r.append(ch);
                }
            }
        }
        return r.toString();
    }
}