package tree;

import java.util.*;

public class Binary_Tree_Preorder_Traversal_144 {

    /*
     * Solution: Recursive 
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
}
