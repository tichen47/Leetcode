package tree;

import java.util.*;

public class Binary_Search_Tree_Iterator_173 {
    Deque<TreeNode> stack;
    TreeNode cur;

    public Binary_Search_Tree_Iterator_173(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode temp = stack.pop();
        cur = temp.right;
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty() && cur == null);
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}


