package array;

import java.util.*;

public class Spiral_Matrix_54 {
    /*
     * Solution: Layer by Layer
     * Time Complexity: O(MN)
     * Space Complexity: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        int rowMin = 0, rowMax = matrix.length - 1;
        int colMin = 0, colMax = matrix[0].length - 1;
        while(rowMin <= rowMax && colMin <= colMax) {
            for(int i = colMin; i <= colMax; i++)
                ans.add(matrix[rowMin][i]);
            rowMin++;

            for(int i = rowMin; i <= rowMax; i++)
                ans.add(matrix[i][colMax]);
            colMax--;

            if(rowMin > rowMax || colMin > colMax) break;

            for(int i = colMax; i >= colMin; i--)
                ans.add(matrix[rowMax][i]);
            rowMax--;

            for(int i = rowMax; i >= rowMin; i--)
                ans.add(matrix[i][colMin]);
            colMin++;
        }
        return ans;
    }
}
