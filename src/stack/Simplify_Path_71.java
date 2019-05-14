package stack;

import java.util.*;

public class Simplify_Path_71 {
    
    /*
     * Solution: Stack 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(tokens[i]))
                stack.push(tokens[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
