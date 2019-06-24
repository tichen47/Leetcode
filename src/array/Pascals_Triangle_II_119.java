package array;

import java.util.*;

public class Pascals_Triangle_II_119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++){
            ans[i] = 1;
            for(int j = i - 1; j > 0; j--){
                ans[j] += ans[j-1];
            }
        }
        return Arrays.asList(ans);
    }
}
