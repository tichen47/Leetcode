package tree;

import java.util.*;

public class Binary_Tree_Postorder_Traversal_145 {

    /*
     * Solution: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(ls, root);
        return ls;
    }

    public void helper(List<Integer> ls, TreeNode root) {
        if (root == null)
            return;
        helper(ls, root.left);
        helper(ls, root.right);
        ls.add(root.val);
    }

    /*
     * Solution 2: Iterative 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                ret.add(0, p.val);
                p = p.right; // Reverse of preorder
            } else {
                TreeNode node = s.pop();
                p = node.left; // Reverse of preorder
            }
        }
        return ret;
    }
}
