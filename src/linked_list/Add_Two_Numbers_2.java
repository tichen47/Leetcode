package linked_list;

public class Add_Two_Numbers_2 {

    /*
     * Solution:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        boolean addition = false;
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        ListNode temp;
        while (true) {
            if (l1 == null && l2 == null) {
                if (addition) {
                    head.next = new ListNode(1);
                }
                break;
            } else if (l1 == null)
                l1 = new ListNode(0);
            else if (l2 == null)
                l2 = new ListNode(0);

            int sum = l1.val + l2.val;
            if (addition)
                sum++;

            temp = new ListNode(sum % 10);
            addition = false;

            if (sum >= 10)
                addition = true;

            head.next = temp;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return ret.next;
    }

    // Definition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
