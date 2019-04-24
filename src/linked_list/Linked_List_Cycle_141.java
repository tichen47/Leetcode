package linked_list;

import java.util.*;

public class Linked_List_Cycle_141 {
    
    /*
     * Solution: Hash set
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
    
    /*
     * Solution: Two Pointer
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
