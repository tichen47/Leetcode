package linked_list;

public class Remove_Duplicates_from_Sorted_List_83 {

    
    /*
     * Solution: Faster than the next solution 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode ret = head;
        ListNode temp = head;
        
        while(head != null){
            if(head.val != temp.val){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return ret;
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
    
    // Definition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
