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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int k=(count-n)+1;
        ListNode m=deleteNode(head,k);
        return m;
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


//slow fast
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        ListNode slow=head;
        if (fast == null)
            return head.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }
}