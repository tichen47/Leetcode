package linked_list;

public class Swap_Nodes_in_Pairs_24 {

    /*
     * Solution: Iteration
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = pre.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
    
    /*
     * Solution: Recursion 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        
        first.next = swapPairs(second.next);
        second.next = first;
        
        return second;
    }
}
