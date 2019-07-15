package linked_list;

public class Remove_Nth_Node_From_End_of_List_19 {
    
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 0; i < n; i++)
            fast = fast.next;
    
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
