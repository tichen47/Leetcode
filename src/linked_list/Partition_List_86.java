package linked_list;

public class Partition_List_86 {

    /*
     * Solution: 
     * Time Complexity: O(n) 
     * Space Complexity: O(n)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                temp1.next = head;
                temp1 = temp1.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        temp2.next = null;
        temp1.next = dummy2.next;
        return dummy1.next;
    }
}
