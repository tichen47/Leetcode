package dynamic_programming;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    
    /*
     * Solution 1: 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max = Math.max(max, prices[i] - prices[i-1]);
                prices[i] = prices[i-1];
            }   
        }
        return max;
    }
    
    
    /*
     * Solution 2: 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
