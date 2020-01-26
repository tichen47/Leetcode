package backtracking;

import java.util.*;

public class Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i < n; i++) {
            int base = 1 << i;
            for(int j = res.size() - 1; j >= 0; j--)
                res.add(res.get(j) + base);
        }
        return res;
    }
}
