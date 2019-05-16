package tree;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_102 {
    
    /*
     * Solution 1: BFS with queue 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> tempLs = new ArrayList<>();
            int num = queue.size();
            
            for(int i = 0; i < num; i++){
                TreeNode node = queue.remove();
                tempLs.add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            ret.add(tempLs);
        }
        return ret;
    }
    
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(root, ret, 0);
        return ret;
    }
    
    public void helper(TreeNode root, List<List<Integer>> ret, int level){
        if(root == null) return;
        
        if(ret.size() <= level){
            List<Integer> temp = new ArrayList<>();
            ret.add(temp);
        }
        
        ret.get(level).add(root.val);
        
        helper(root.left, ret, level+1);
        helper(root.right, ret, level+1);
    }
}
