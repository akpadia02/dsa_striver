class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; 
        while (even != null && even.next != null) {
            odd.next = even.next; 
            odd = odd.next;      

            even.next = odd.next; 
            even = even.next;  
        }
        odd.next = evenHead;

        return head; 
    }
}


//arr
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        List<Integer> arr = new ArrayList<>();
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            arr.add(temp.val);
            temp=temp.next.next;
        }
        if(temp!=null){
            arr.add(temp.val);
        }
        temp=head.next;
        while(temp!=null && temp.next!=null){
            arr.add(temp.val);
            temp=temp.next.next;
        }
        if(temp!=null){
            arr.add(temp.val);
        }
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val=arr.get(i);
            i++;
            temp=temp.next;
        }
        return head;
    }
}
