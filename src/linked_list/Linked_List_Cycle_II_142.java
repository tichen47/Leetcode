package linked_list;

public class Linked_List_Cycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode walk = head;
        ListNode run = head;
        
        // Find the meeting point
        while(run != null && run.next != null){
            run = run.next.next;
            walk = walk.next;
            if(run == walk) break;
        }
        if(run == null || run.next == null) return null;
        
        // Walk and run will alwasy meet at the entry node
        walk = head;
        while(walk != run){
            walk = walk.next;
            run = run.next;
        }
        return walk;
    }
}
