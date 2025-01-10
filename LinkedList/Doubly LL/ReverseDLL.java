//using stack
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if (head == null) {
            return null;
        }

        Stack<DLLNode> stack = new Stack<>();
        DLLNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        head = stack.pop(); 
        current = head;
        current.prev = null; 

        while (!stack.isEmpty()) {
            DLLNode temp = stack.pop();
            current.next = temp;
            temp.prev = current;
            current = temp;
        }
        current.next = null;
        return head;
    }
}


//swaping
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
         if (head == null || head.next == null) {
            return head; 
        }
        DLLNode p = null;
        DLLNode current = head;
        while (current != null) {
            p = current.prev;
            current.prev = current.next;
            current.next = p;
            current = current.prev;
        }
        return p.prev;
    }
}