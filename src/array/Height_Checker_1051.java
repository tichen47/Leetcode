package array;

import java.util.*;

public class Height_Checker_1051 {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(heights);
        int ret = 0;
        for(int i = 0; i < heights.length; i++){
            if(temp[i] != heights[i])
                ret++;
        }
        return ret;
    }
}
