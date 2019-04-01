package stack;

import java.util.*;

public class Valid_Parentheses_20 {
    
    /*
     * Solution: Stack
     * Time Complexity: O(N)
     * Space Complexity: O(N) 
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') 
                stack.push(')');
            else if(c == '[') 
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
