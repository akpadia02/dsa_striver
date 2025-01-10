public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
        
    }
}

//hashing
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp,1);
            temp=temp.next;
        }
        return false;
    }
}


//return node
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}


//count cycle nodes
class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow=head;
        Node fast=head;
        int count=1;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                Node temp=slow;
                while(temp.next!=slow){
                    count++;
                    temp=temp.next;
                }
                return count;
            }
        }
        return 0;
    }
}