package linked_list;

public class Remove_Linked_List_Elements_203 {

    /*
     * Solution: Iterative 
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null) {
            if (temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return dummy.next;
    }

    /*
     * Solution: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
