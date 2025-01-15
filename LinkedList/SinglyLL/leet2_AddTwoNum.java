class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode node = new ListNode(-1);
        ArrayList<Integer> a = new ArrayList<>();
        int carry = 0;
        while (temp1 != null || temp2 != null || carry != 0) {
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;

            int sum = val1 + val2 + carry;
            a.add(sum % 10);
            carry = sum / 10;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int num : a) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }
}