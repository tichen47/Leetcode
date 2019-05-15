package tree;

import java.util.*;

public class Binary_Tree_Inorder_Traversal_94 {

    /*
     * Solution: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(ls, root);
        return ls;
    }

    public void helper(List<Integer> ls, TreeNode root) {
        if (root == null)
            return;
        helper(ls, root.left);
        ls.add(root.val);
        helper(ls, root.right);
    }

    /*
     * Solution 2: Iterative 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                TreeNode node = s.pop();
                ret.add(node.val);
                p = node.right;
            }
        }
        return ret;
    }
}
