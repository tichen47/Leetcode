package tree;

import java.util.*;

public class Binary_Search_Tree_Iterator_173 {
    TreeNode root;
    Deque<TreeNode> stack;
    
    // Modify class name here for submission
    public Binary_Search_Tree_Iterator_173(TreeNode root) {
        stack = new LinkedList<>();
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        if(root == null){
            root = stack.pop();
            int ret = root.val;
            root = root.right;
            return ret;
        }
        else{
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            return next();
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty() && root == null);
    }
    
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}


