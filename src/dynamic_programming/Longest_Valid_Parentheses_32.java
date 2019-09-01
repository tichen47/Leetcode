package dynamic_programming;

import java.util.*;

public class Longest_Valid_Parentheses_32 {

    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int res = 0;
        for(int i = 1; i < str.length; i++) {
            if(str[i] == '(') continue;

            if(str[i - 1] == '(') // ...()
                dp[i] = i >= 2 ? dp[i-2] + 2 : 2;
            else { // ...))
                int prevIndex = i - dp[i - 1] - 1;
                if(prevIndex >= 0 && str[prevIndex] == '(') {
                    int prevLen = prevIndex > 0 ? dp[prevIndex - 1] : 0;
                    dp[i] = dp[i - 1] + prevLen + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
     * Solution: Stack
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestValidParentheses2(String s) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

    /*
     * Solution: Two Pointer
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int longestValidParentheses3(String s) {
        int res = 0;

        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;

            if(left == right)
                res = Math.max(res, right * 2);

            if(left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '(') left++;
            else right++;

            if(left == right)
                res = Math.max(res, right * 2);

            if(left > right) {
                left = 0;
                right = 0;
            }
        }

        return res;
    }
}
