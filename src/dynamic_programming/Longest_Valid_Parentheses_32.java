package dynamic_programming;

import java.util.*;

public class Longest_Valid_Parentheses_32 {

    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];

        for(int i = 1; i < str.length; i++){

            if(str[i] == ')') {
                if (str[i - 1] == '(')
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;

                else if (i - dp[i - 1] > 0 && str[i - dp[i - 1] - 1] == '(') {
                    int prev = i - dp[i - 1] - 2;
                    int prevLen = prev < 0 ? 0 : dp[prev];
                    dp[i] = dp[i - 1] + 2 + prevLen;
                }
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
     * Solution: DP
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
