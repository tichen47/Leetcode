package tree;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
    
    /*
     * Solution 1: BFS with queue 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int num = queue.size();
            for(int i = 0; i < num; i++){
                TreeNode node = queue.remove();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            if(level % 2 == 0) Collections.reverse(temp);
            ret.add(temp);
            level++;
        }
        return ret;
    }
}
