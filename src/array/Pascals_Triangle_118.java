package array;

import java.util.*;

public class Pascals_Triangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0) return ret;
        
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        ret.add(new ArrayList<>(cur));
        
        for(int i = 2; i <= numRows; i++){
            int n = cur.size();
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < n; j++){
                temp.add(cur.get(j-1) + cur.get(j));
            }
            temp.add(1);
            cur = temp;        
            ret.add(new ArrayList<>(cur));
        }
        return ret;
    }
}
