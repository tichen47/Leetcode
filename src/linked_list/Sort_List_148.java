package linked_list;

public class Sort_List_148 {
    /*
     * Solution: Merge Sort
     * Time Complexity: O(NlogN)
     * Space Complexity: O(logN)
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;    
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secHead = slow.next;
        slow.next = null;
        
        ListNode first = sortList(head);
        ListNode sec = sortList(secHead);
        
        return mergeList(first, sec);
    }
    
    public ListNode mergeList(ListNode first, ListNode sec){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(first != null && sec != null){
            if(first.val > sec.val){
                temp.next = sec;
                sec = sec.next;
            }
            else {
                temp.next = first;
                first = first.next;
            }
            temp = temp.next;
        }
        temp.next = first == null ? sec : first;
        return dummy.next;
    }
}
