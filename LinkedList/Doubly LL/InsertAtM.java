class Solution {
    // Function to insert a new node at a given position in a doubly linked list.
    Node addNode(Node head, int m, int x) {
        Node newNode = new Node(x);

        // If the list is empty or inserting at the head
        if (head == null || m == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode; // Return the new head
        }

        // Traverse to the (m-1)th node
        Node temp = head;
        int index = 1;
        while (temp != null && index < m - 1) {
            temp = temp.next;
            index++;
        }

        // If temp is null, the position is invalid (beyond the list size)
        if (temp == null) {
            return head; // Return the unchanged list
        }

        // Insert the new node after temp
        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = nextNode;

        // Update the prev pointer of the next node, if it exists
        if (nextNode != null) {
            nextNode.prev = newNode;
        }

        return head; // Return the unchanged head
    }
}
