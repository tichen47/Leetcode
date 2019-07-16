package linked_list;

public class Swap_Nodes_in_Pairs_24 {

    /*
     * Solution: Iteration
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null){
            // Ex: 0(pre)->1->2->3->4  
            // Goal: Swap 1 and 2
            ListNode cur = pre.next;   // pre: 0, cur: 1
            pre.next = cur.next;       // 0->2  
            cur.next = cur.next.next;  // 1->3  
            pre.next.next = cur;       // 2->1  (Achieve: 0(pre)->2->1->3->4)
            
            pre = pre.next.next;       // (0(->2->1(pre)->3->4)
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
