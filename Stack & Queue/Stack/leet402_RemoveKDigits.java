class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            int r=num.charAt(i)- '0';
            while (!st.isEmpty() && k > 0 && st.peek() > r) {
                st.pop();
                k--;
            }
            st.push(r);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();

        while (result.length()>1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();

    }
}