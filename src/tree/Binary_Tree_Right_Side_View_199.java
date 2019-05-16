package tree;

import java.util.*;

public class Binary_Tree_Right_Side_View_199 {
    
    /*
     * Solution 1: BFS with queue 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int right = -1;
            int num = queue.size();
            for(int i = 0; i < num; i++){
                TreeNode node = queue.remove();
                right = node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ret.add(right);
        }
        return ret;
    }

    /*
     * Solution 2: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(ret, root, 0);
        return ret;
    }
    
    public void helper(List<Integer> ret, TreeNode root, int level){
        if(root == null) return;
        if(ret.size() == level) ret.add(root.val);
        
        helper(ret, root.right, level+1);
        helper(ret, root.left, level+1);
    }
}
