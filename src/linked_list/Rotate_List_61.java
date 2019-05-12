package linked_list;

public class Rotate_List_61 {
    /*
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int len = 1;
        ListNode p = head;

        // Get the length of the linked list
        while (p.next != null) {
            len++;
            p = p.next;
        }

        // Make the linked-list as a cycle
        p.next = head;

        // Find the tail of new list
        for (int i = 0; i < (len - k % len - 1); i++) {
            head = head.next;
        }

        ListNode ret = head.next;
        head.next = null;
        return ret;
    }
}
