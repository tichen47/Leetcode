package linked_list;

public class Add_Two_Numbers_2 {

    /*
     * Solution:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        
        int flag = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + flag;
            dummy.next = new ListNode(sum % 10);
            flag = sum >= 10 ? 1 : 0;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            dummy = dummy.next;
        }
        if(flag == 1) dummy.next = new ListNode(flag);
        return ret.next;
    }
    
    public static void main(String[] args) {
        int[] t1 = new int[] {1, 8};
        int[] t2 = new int[] {0};
        ListNode l1 = new ListNode(t1);
        ListNode l2 = new ListNode(t2);
        Add_Two_Numbers_2 a = new Add_Two_Numbers_2();
        ListNode ret = a.addTwoNumbers2(l1, l2);
        System.out.println(ret);
    }
}
