package tree;

import java.util.*;

public class Binary_Tree_Preorder_Traversal_144 {

    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(ls, root);
        return ls;
    }

    public void helper(List<Integer> ls, TreeNode root) {
        if (root == null)
            return;
        ls.add(root.val);
        helper(ls, root.left);
        helper(ls, root.right);
    }

    /*
     * Solution 2: Iterative 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            ret.add(node.val);
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        return ret;
    }

    /*
     * Solution 3: Iterative 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p.right);
                ret.add(p.val);
                p = p.left;
            } else {
                p = s.pop();
            }
        }
        return ret;
    }
}
