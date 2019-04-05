package array;

import java.util.Arrays;

public class Plus_One_66 {
    
    /*
     * Solution: straight forward
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] plusOne(int[] digits) {
        int[] ret = new int[digits.length+1];
        ret[ret.length-1] = 1;
        
        for(int i = ret.length-1; i > 0; i--){
            int sum = ret[i] + digits[i-1];
            if(sum >= 10)
                ret[i-1] = 1;
            ret[i] = sum % 10;
        }
        if(ret[0] == 0)
            return Arrays.copyOfRange(ret, 1, ret.length);
        else 
            return ret;
    }
    
    /*
     * Solution: smart and nice 
     * Time Complexity: O(N*2)
     * Space Complexity: O(N)
     */
    public int[] plusOne2(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }
}
