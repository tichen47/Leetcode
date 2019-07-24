package tree;

import java.util.*;

public class Validate_Binary_Search_Tree_98 {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    /*
     * Use Integer instead of int for max and min
     * Reason: If we use int, initial value will be Integer.MAX_VALUE and Integer.MIN_VALUE
     * Result may be wrong if val = Integer.MAX_VALUE or Integer.MIN_VALUE 
     */
    public boolean isValidBST(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        
        if((max != null && root.val >= max) 
           || (min != null && root.val <= min)) return false;
        
        boolean isValidLeft = isValidBST(root.left, root.val, min);
        boolean isValidRight = isValidBST(root.right, max, root.val);
        return isValidLeft && isValidRight;
    }
    
    
    /*
     * Solution 2: Iterative DFS
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer min = null;
        
        while((!stack.isEmpty()) || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(min != null && root.val <= min) return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }
}
