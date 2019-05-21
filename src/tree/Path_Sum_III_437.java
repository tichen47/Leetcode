package tree;

public class Path_Sum_III_437 {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int findPath(TreeNode root, int sum){
        if(root == null) return 0;
        int count = root.val == sum ? 1 : 0;
        count += findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
        return count;
    }
}
