package linked_list;

public class Insertion_Sort_List_147 {
    
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        
        while(head != null){
            ListNode t = dummy;
            
            while(t.next != null && t.next.val < head.val){
                t = t.next;
            }
            
            ListNode hNext = head.next;
            head.next = t.next;
            t.next = head;
            head = hNext;
        }
        return dummy.next;
    }
}
