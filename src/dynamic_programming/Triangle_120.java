package dynamic_programming;

import java.util.*;

public class Triangle_120 {
    /*
     * Solution: DP: bottom up
     * Time Complexity: O(N) N: height of triangle
     * Space Complexity: O(N)
     */ 
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        
        for(int i = triangle.size() - 1; i >= 0; i--){
            int len = triangle.get(i).size();
            for(int j = 0; j < len; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    
    /*
     * Solution: DP: top down
     * Time Complexity: O(N) N: height of triangle
     * Space Complexity: O(N)
     */ 
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        // Make a Dp array with same size to the botton of triangle
        int[] dp = new int[triangle.size()];
        
        for(List<Integer> row : triangle){
            int[] tempDp = new int[dp.length];
            for(int i = 0; i < row.size(); i++){
                if(i == 0)
                    tempDp[i] = dp[i] + row.get(i);
                else if(i == row.size() - 1)
                    tempDp[i] = dp[i-1] + row.get(i);
                else
                    tempDp[i] = Math.min(dp[i], dp[i-1]) + row.get(i);
            }
            dp = tempDp;
            
        }
        
        int min = dp[0];
        for(int i = 1; i < dp.length; i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }
    
    
}
