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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        int[] arr=new int[n];
        temp=head;
        int index=0;
        while(temp!=null && index<n){
            arr[index]=temp.val;
            temp=temp.next;
            index++;
        }
        k=k%n;
        reverse(0,arr,n-1-k);
        reverse(n-k,arr,n-1);
        reverse(0,arr,n-1);

        temp = head;
        index = 0;
        while (temp != null) {
            temp.val = arr[index];
            temp = temp.next;
            index++;
        }

        return head; 
    }

    public static void reverse(int i,int[] arr,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}




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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head; 
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if(k%length==0) return head;
        k = k % length;
        tail.next=head;
        ListNode newLastNode=findNthNode(head,length-k-1);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;
    }

    private ListNode findNthNode(ListNode head, int n) {
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current;
    }
}