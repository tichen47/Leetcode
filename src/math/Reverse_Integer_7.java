package math;

public class Reverse_Integer_7 {
    
    /*
     * Solution: 
     * Time Complexity: O(N), N is the number of digitals of x
     * Space Complexity: O(1)
     */
    public int reverse(int x) {
        int ret = 0;
        int digit, flag;
        // Can't be x > 0, since x can be negative 
        while(x != 0){
            digit = x % 10;
            flag = ret;
            ret = ret * 10 + digit;
            if((ret-digit)/10 != flag) return 0;  // Check for overflow
            x /= 10;
        }
        return ret;
    }
}
