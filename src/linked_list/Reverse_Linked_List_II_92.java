package linked_list;

public class Reverse_Linked_List_II_92 {
    
    /*
     * Solution: Iterative
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        // head is keep changing, make a dummy node to mark the head of the list
        ListNode dummy = new ListNode(0);  
        dummy.next = head;
        
        // make a node stay at the position before reversing
        ListNode pre = dummy; 
        for(int i = 0; i < m - 1; i++) pre = pre.next;
        
        
        ListNode start = pre.next; // The first node of the reversed part
        ListNode then = start.next; // The node will be reversed
        
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        for(int i = 0; i < n - m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}
