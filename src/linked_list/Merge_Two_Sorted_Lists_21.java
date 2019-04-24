package linked_list;

public class Merge_Two_Sorted_Lists_21 {

    /*
     * Solution 2: Recursion
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
    
    /*
     * Solution 2: Iteration
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode temp = ret;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else{
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return ret.next;
    }
    
}
