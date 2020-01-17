package backtracking;

import java.util.*;

public class Cracking_the_Safe_753 {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append("0");

        int total = (int) Math.pow(k, n);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(n, k, total, visited, sb);
        return sb.toString();
    }

    public boolean dfs(int n, int k, int total, Set<String> visited, StringBuilder sb) {
        if(visited.size() == total)
            return true;

        String last = sb.substring(sb.length() - n + 1); // Last n - 1 digits
        for(char ch = '0'; ch < '0' + k; ch++) {
            String cur = last + ch;
            if(!visited.contains(cur)) {
                visited.add(cur);
                sb.append(ch);
                if(dfs(n, k, total, visited, sb))
                    return true;
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(cur);
            }
        }
        return false;
    }
}
