package hash_table;

import java.util.*;
 
public class Flip_Columns_For_Maximum_Number_of_Equal_Rows_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            List<Integer> zeros = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();
            
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0)
                    zeros.add(j);
                else
                    ones.add(j);
            }
            
            map.put(zeros, map.getOrDefault(zeros, 0) + 1);
            map.put(ones, map.getOrDefault(ones, 0) + 1);
        }
        
        int ret = 0;
        for(Map.Entry<List<Integer>, Integer> entry : map.entrySet()){
            ret = Math.max(ret, entry.getValue());
        }
        
        return ret;
    }
}
