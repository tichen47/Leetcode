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
}
