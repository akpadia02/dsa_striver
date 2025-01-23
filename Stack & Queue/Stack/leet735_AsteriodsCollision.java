class Solution {
    public int[] asteroidCollision(int[] a) {
        int n=a.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            int r=a[i];
            if(r>=0){
                st.push(r);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(r)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(r)){
                    st.pop();
                }else if(st.isEmpty() || st.peek()<0){
                    st.push(r);
                }
            }
            
        }
        int[] result = new int[st.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i] = st.pop();
        }
        return result;
    }
}