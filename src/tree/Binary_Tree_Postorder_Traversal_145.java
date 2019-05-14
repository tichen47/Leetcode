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
}
