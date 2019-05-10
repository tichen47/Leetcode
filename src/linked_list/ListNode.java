package linked_list;

//Definition for singly-linked list.
public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    // Create a linked list by array
    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("");
        ListNode curNode = this;
        while (curNode != null) {
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }

    // Test
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        ListNode head = new ListNode(array);
        System.out.println(head);
    }
}