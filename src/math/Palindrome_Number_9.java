package math;

public class Palindrome_Number_9 {
    
    /*
     * Solution 1: String
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    
    /*
     * Solution 2: Math
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome2(int x) {
        if(x < 0)
            return false;
        
        int temp = x;
        int reverse = 0;
        while(temp > 0){
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return reverse == x;
    }
    
}
