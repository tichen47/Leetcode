package tree;

public class Maximum_Average_Subtree_1120 {
    double max;
    
    public double maximumAverageSubtree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    public Pair helper(TreeNode root){
        int sum = root.val;
        int num = 1;
        
        if(root.left != null){
            Pair l = helper(root.left);
            sum += l.sum;
            num += l.num;
        }
        
        if(root.right != null){
            Pair r = helper(root.right);
            sum += r.sum;
            num += r.num;
        }
        
        max = Math.max(max, sum * 1.0 / num);
        return new Pair(sum, num);
    }
    
    class Pair {
        int sum;
        int num;
        Pair(int sum, int num){
            this.sum = sum;
            this.num = num;
        }
    }
}
