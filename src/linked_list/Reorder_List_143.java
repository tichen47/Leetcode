package linked_list;

public class Reorder_List_143 {
    
    /*
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
    
        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the sencond half list, set the tail of first list to null
        ListNode sec = reverseList(slow.next);
        slow.next = null;
        
        // Combine the two list
        ListNode p = head;
        while(sec != null){
            ListNode temp = sec.next;
            sec.next = p.next;
            p.next = sec;
            p = p.next.next;
            sec = temp;
        }
        
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4}; // 1 4 2 3
        ListNode head = new ListNode(nums);
        Reorder_List_143 r = new Reorder_List_143();
        r.reorderList(head);
        System.out.println(head);
    }
}
