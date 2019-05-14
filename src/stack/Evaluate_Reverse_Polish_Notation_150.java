package stack;

import java.util.*;

public class Evaluate_Reverse_Polish_Notation_150 {
    
    /*
     * Solution: Stack 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
            case "+":
                s.push(s.pop() + s.pop());
                break;
            case "-":
                s.push(-s.pop() + s.pop());
                break;
            case "*":
                s.push(s.pop() * s.pop());
                break;
            case "/":
                int a = s.pop();
                int b = s.pop();
                s.push(b / a);
                break;
            default:
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
