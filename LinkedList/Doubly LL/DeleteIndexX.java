Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // Edge case: if the list is empty
        if (head == null) return null;

        // Case 1: Deleting the head node (position 1)
        if (x == 1) {
            Node temp = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            temp.next = null; // Free the reference to the old head node
            return head;
        }

        // Case 2: Deleting a node at position other than 1
        Node temp = head;
        int index = 1;

        // Traverse to the node at position x
        while (temp != null) {
            if (index == x) {
                // If it's the last node
                if (temp.next == null) {
                    Node p = temp.prev;
                    p.next = null; 
                    temp.prev = null;
                } else {
                    // If it's a middle node
                    Node p = temp.prev;
                    Node f = temp.next;
                    p.next = f;
                    f.prev = p;
                    temp.next = null;
                    temp.prev = null;
                }
                break;
            }
            temp = temp.next;
            index++;
        }

        return head;
    }
}