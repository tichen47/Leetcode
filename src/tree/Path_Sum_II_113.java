package tree;

import java.util.*;

public class Path_Sum_II_113 {
    
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        List<Integer> path = new ArrayList<>();
        helper(ret, path, root, sum);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, List<Integer> path, TreeNode root, int sum){
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(sum == root.val)
                ret.add(new ArrayList<Integer>(path));
        }
        
        if(root.left != null)  helper(ret, path, root.left, sum - root.val);
        if(root.right != null) helper(ret, path, root.right, sum - root.val);
        
        path.remove(path.size() - 1);
    }
}
