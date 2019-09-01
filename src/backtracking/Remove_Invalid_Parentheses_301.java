package backtracking;

import java.util.*;

public class Remove_Invalid_Parentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, '(', ')');
        return res;
    }

    public void remove(String s, List<String> res, int iStart, int jStart, char openParen, char closeParen) {
        int numOpen = 0, numClose = 0;
        for(int i = iStart; i < s.length(); i++) {
            if(s.charAt(i) == openParen) numOpen++;
            if(s.charAt(i) == closeParen) numClose++;

            if(numClose > numOpen) {
                for(int j = jStart; j <= i; j++) {
                    if(s.charAt(j) == closeParen && (j == jStart || s.charAt(j - 1) != closeParen))
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, openParen, closeParen);
                }
                return;
            }
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(openParen == '(')
            remove(reverse, res, 0, 0, closeParen, openParen);
        else
            res.add(reverse);
    }
}
