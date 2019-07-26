package tree;

import java.util.*;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    Map<Integer, Integer> map;
    int[] pre;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        map = new HashMap<>();
        int n = inorder.length;
        
        for(int i = 0; i < n; i++)
            map.put(inorder[i],i);
        
        return helper(0, 0, n-1);
    }
    
    public TreeNode helper(int pre_index, int left, int right){
        if(left > right) return null;
        
        TreeNode root = new TreeNode(pre[pre_index]);
        
        int index = map.get(root.val);
        
        int lenLeftTree = index - left;
        root.left = helper(pre_index + 1, left, index-1);
        root.right = helper(pre_index + lenLeftTree + 1, index+1, right);
        return root;
    }
}
