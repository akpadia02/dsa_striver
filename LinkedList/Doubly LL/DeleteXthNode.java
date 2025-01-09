class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if (head == null) return null;
        if (head.data == x) {
            Node p = head;
            head = head.next;  
            if (head != null) {
                head.prev = null;  
            }
            p.next = null;  
            return head;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp.next != null) {
                    Node p = temp.prev;
                    Node f = temp.next;
                    p.next = f;
                    f.prev = p;
                    temp.next = null;
                    temp.prev = null;
                } else {
                    Node p = temp.prev;
                    p.next = null; 
                    temp.prev = null;
                }
                return head; 
            }
            temp = temp.next;  
        }
        return head;
    }
}