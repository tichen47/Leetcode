package linked_list;

import java.util.*;

public class Intersection_of_Two_Linked_Lists_160 {
    
    /*
     * Solution: 
     * Time Complexity: O(M + N)
     * Space Complexity: O(M) 
     */ 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
    
    /*
     * Solution: Two Pointer
     * Time Complexity: O(M + N)
     * Space Complexity: O(1) 
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            // Cant use a.next == null
            // The loop will never stop if there is no intersection
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
    
}
