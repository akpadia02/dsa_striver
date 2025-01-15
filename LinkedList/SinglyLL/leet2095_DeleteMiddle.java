/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return deleteNode(head,(count/2)+1);
    }
    public ListNode deleteNode(ListNode head, int k) {
        if(head==null || k<=0){
            return null;
        }
        if(k==1){
            head=head.next;
            return head;
        }
        ListNode temp=head;
        int count=1;
        while(temp!=null && count<k-1){
            temp=temp.next;
            count++;
        }
        if(temp==null || temp.next==null){
            return head;
        }
        temp.next=temp.next.next;
        return head;
    }
}

//slow fast(slow skip 1)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if (head == null || head.next == null) {
            return null;
        }
        fast=fast.next.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode delete=slow.next;
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        delete=null;
        return head;
    }
}