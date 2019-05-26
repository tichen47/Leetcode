package sliding_window;

public class Grumpy_Bookstore_Owner_1052 {
    /*
     * Sliding Window
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // Find the max number of unsatisfied customers in X minutes, add all the satisfied customers 
        
        int satisified = 0; // Total number of satisfied customers
        int max = 0;  // Max number of unsatisfied customers in X minutes
        int cur = 0;  // Current number of unsatisfied customers
        int l = -1, r = -1;
        
        while(r < grumpy.length - 1){
            if(r - l < X){
                r++;
                if(grumpy[r] == 1){
                    cur += customers[r];
                    max = Math.max(max, cur);
                }
                else
                    satisified += customers[r];
            }
            else{
                l++;
                if(grumpy[l] == 1)
                    cur -= customers[l];
            }
        }
        return max + satisified;
    } 
}
