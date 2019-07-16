package linked_list;

public class Reverse_Linked_List_206 {
    
    /*
     * Solution: Iterative
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    
    /*
     * Solution: Recursive
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
