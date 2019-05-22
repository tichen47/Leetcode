package tree;

import java.util.*;

public class Validate_Binary_Search_Tree_98 {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode root, Integer low, Integer high){
        if(root == null) return true;
        
        int val = root.val;
        if(low != null && val <= low) return false;
        if(high != null && val >= high) return false;
        
        if(!helper(root.left, low, val)) return false;
        if(!helper(root.right, val, high)) return false;
        
        return true;
    }
    
    
    /*
     * Solution 2: Iterative DFS
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    Stack<TreeNode> stack;
    Stack<Integer> low;;
    Stack<Integer> high;
    
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;

        stack = new Stack<>();
        low = new Stack<>();
        high = new Stack<>();
        
        update(root, null, null);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            Integer lowValue = low.pop();
            Integer highValue = high.pop();
            
            if(lowValue != null && node.val <= lowValue) return false;
            if(highValue != null && node.val >= highValue) return false;
            
            if(node.left != null) update(node.left, lowValue, node.val);
            if(node.right != null) update(node.right, node.val, highValue);
        }
        return true;
    }
    
    public void update(TreeNode node, Integer lowValue, Integer highValue){
        stack.push(node);
        low.push(lowValue);
        high.push(highValue);
    }
}
