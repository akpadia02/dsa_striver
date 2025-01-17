import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        HashSet<ListNode> st = new HashSet<>();
        while (head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (st.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;

        while(tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
            
            if(tempA==null && tempB==null){
                return null;
            }
            if(tempA==null){
                tempA=headB;
            }
            if(tempB==null){
                tempB=headA;
            }
        }
        return tempA;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        // Find lengths of both lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        // Move the longer list head to make them equal length
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        
        // Traverse both lists until intersection node is found
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;  // Return the intersection node or null if no intersection
    }
    
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}