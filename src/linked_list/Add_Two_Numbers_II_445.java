package linked_list;

import java.util.*;

public class Add_Two_Numbers_II_445 {
    
    /*
     * Solution: Two Stacks
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int flag = 0;
        while ((!s1.isEmpty()) || (!s2.isEmpty())) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = v1 + v2 + flag;
            ListNode temp = new ListNode(sum % 10);
            temp.next = head;
            head = temp;
            flag = sum >= 10 ? 1 : 0;
        }

        if (flag == 1) {
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }

        return head;
    }
    
    // Understand recursive solution next time
}
