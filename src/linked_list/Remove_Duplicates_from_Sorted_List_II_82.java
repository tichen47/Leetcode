package linked_list;

public class Remove_Duplicates_from_Sorted_List_II_82 {

    /*
     * Solution: Straight Forward
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while(pre.next != null && pre.next.next != null){
            if(pre.next.val == pre.next.next.val){
                ListNode temp = pre.next;
                while(temp.next != null && temp.next.val == temp.val){
                    temp = temp.next;
                }
                pre.next = temp.next;
            }
            else pre = pre.next;
        }
        return dummy.next;
    }

    /*
     * Solution: Iterative Two Pointer 
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = slow.next;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if (slow.next != fast) { // Key Part
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
    
    /*
     * Solution: Recursive
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if(head == null) return null;
        
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val)
                head.next = head.next.next;
            return deleteDuplicates(head.next);
        }
        
        head.next = deleteDuplicates(head.next);
        return head;
    }
    
}
