package linked_list;

public class Remove_Nth_Node_From_End_of_List_19 {
    
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walk = dummy;
        ListNode run = dummy;
        
        for(int i = 0; i < n; i++){
            run = run.next;  // Assume n always be valid
        }
        
        while(run.next != null){
            walk = walk.next;
            run = run.next;
        }
        
        walk.next = walk.next.next;  // Delete node
        return dummy.next;
    }
}
