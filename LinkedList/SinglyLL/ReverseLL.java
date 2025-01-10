//stack
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        head = stack.pop(); 
        current = head;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current=current.next;
        }
        current.next = null;
        return head;
    }
}


//changing links
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev,curr,front;
        prev=null;
        curr=head;
        while(curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        head=prev;
        return prev;
    }
}