package linked_list;

public class Rotate_List_61 {
    /*
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        tail.next = head;
        
        int step = len - k % len;
        ListNode end = tail;
        for(int i = 0; i < step; i++){
            end = end.next;
        }
        
        ListNode start = end.next;
        end.next = null;
        return start;
    }
}
