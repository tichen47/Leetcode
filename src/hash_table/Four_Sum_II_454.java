package hash_table;

import java.util.*;

public class Four_Sum_II_454 {

    /*
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int complement = 0 - A[i] - B[j];
                ret += map.getOrDefault(complement, 0);
            }
        }

        return ret;
    }

}
