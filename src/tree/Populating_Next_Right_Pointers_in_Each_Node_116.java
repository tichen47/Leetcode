package tree;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {
    /*
     * Solution: iterative
     * Time Complexity:  O(N)
     * Space Complexity: O(1)
     */
    public Node connect2(Node root) {
        if(root == null) return null;
        Node start = root;
        while(start.left != null) {
            Node cur = start;
            while(cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }

    /*
     * Solution: recursive
     * Time Complexity:  O(N)
     * Space Complexity: O(1)
     * implicit stack space does not count as extra space for this problem.
     */
    public Node connect(Node root) {
        if(root == null || root.left == null) return root;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
