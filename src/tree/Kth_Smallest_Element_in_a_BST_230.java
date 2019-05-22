package tree;

import java.util.*;

public class Kth_Smallest_Element_in_a_BST_230 {
    /*
     * Solution: DFS
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        
        Deque<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(k == 1) return root.val;
            k--;
            root = root.right;
        }
    }
    
    /*
     * Solution: Recursive inorder
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */    
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        inorder(ls, root);
        return ls.get(k-1);
    }
    
    public void inorder(List<Integer> ls, TreeNode root){
        if(root == null) return;
        inorder(ls, root.left);
        ls.add(root.val);
        inorder(ls, root.right);
    }
}
