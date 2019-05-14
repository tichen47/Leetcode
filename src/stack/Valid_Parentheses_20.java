package stack;

import java.util.*;

public class Valid_Parentheses_20 {

    /*
     * Solution: Stack Time 
     * Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        Valid_Parentheses_20 v = new Valid_Parentheses_20();
        System.out.println(v.isValid2(s));
    }
}
