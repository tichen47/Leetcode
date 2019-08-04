package backtracking;

import java.util.*;

public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }
    
    public void generate(List<String> res, String cur, int numL, int numR, int max){
        if(cur.length() == max * 2)
            res.add(cur.toString());
        
        if(numL < max)
            generate(res, cur + "(", numL + 1, numR, max);
        
        if(numR < numL)
            generate(res, cur + ")", numL, numR + 1, max);
    }
}
