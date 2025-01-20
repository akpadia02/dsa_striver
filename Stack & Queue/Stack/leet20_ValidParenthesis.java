class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i != n) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;
                else if (ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                } else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                }else{
                    return false;
                }
            }
            i++;
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}