package heap;

import linked_list.ListNode;
import java.util.*;

public class Merge_k_Sorted_Lists_23 {
    
    /*
     * Solution: Head
     * Time Complexity: ???
     * Space Complexity: O(N)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    /*
     * Solution: Recursive
     * Time Complexity: O(K * N * LogK)  
     * Space Complexity: O(N)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        else if(start < end){
            int mid = (start + end) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            return merge(l1, l2);
        }
        else return null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
