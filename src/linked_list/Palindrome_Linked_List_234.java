package linked_list;

public class Palindrome_Linked_List_234 {

    /*
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // Find the mid point
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode sec = reverseList(slow.next);

        while (sec != null) {
            if (sec.val != head.val)
                return false;
            sec = sec.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
}
