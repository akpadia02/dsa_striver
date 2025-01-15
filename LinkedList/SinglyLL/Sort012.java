class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        int c0=0,c1=0,c2=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                c0++;
            }else if(temp.data==1){
                c1++;
            }else{
                c2++;
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(c0!=0){
                temp.data=0;
                c0--;
            }
            else if(c1!=0){
                temp.data=1;
                c1--;
            }else{
                temp.data=2;
                c2--;
            }
            temp=temp.next;
        }
        return head;
    }
}