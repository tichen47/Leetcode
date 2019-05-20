package tree;

import java.util.Stack;

public class Sum_of_Left_Leaves_404 {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    /*
     * Solution 2: Iterative
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int ans = 0;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                if(node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                stack.push(node.left);
            }
            if(node.right != null) 
                stack.push(node.right);
        }
        return ans;
    }
}
