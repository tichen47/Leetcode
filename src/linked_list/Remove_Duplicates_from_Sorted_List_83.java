package linked_list;

public class Remove_Duplicates_from_Sorted_List_83 {

    
    /*
     * Solution: Two Pointer (Faster than solution 2)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode walk = head;
        ListNode run = head;
        while(run != null){
            if(walk.val != run.val){
                walk.next = run;
                walk = walk.next;
            }
            run = run.next;
        }
        walk.next = null;
        return head;
    }
    

    /*
     * Solution: Straight Forward 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        
        while(cur != null && cur.next != null){
            if(cur.next.val == cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }

    /*
     * Solution: Recursive
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
    
}
