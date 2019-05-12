package search;

public class Sqrt_X_69 {
    
    /*
     * Solution: Binary Search
     * Time Complexity: O(log2(N))
     * Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 1, r = x;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid > x / mid){
                r = mid - 1;
            }
            else{
                if((mid+1) > x/(mid+1)){
                    return mid;
                }
                l = mid + 1;
            }
        }
        return -1;
    }
    
    /*
     * Solution: Newton's method
     * x_(k+1) = 0.5 * (x_k + n / x_k) 
     * Time Complexity: unknown
     * Space Complexity: O(1)
     */
    public int mySqrt2(int x) {
        if(x == 0)
            return 0;
        long k = x; // Must be long
        while(k > (x / k)){  
            k = (k + x / k) / 2;
        }
        return (int)k;
    }
}
