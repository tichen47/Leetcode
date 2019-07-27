package array;

import java.util.*;

public class Largest_Unique_Number_5034 {
    public int largestUniqueNumber(int[] A) {
        Arrays.sort(A);
        int n = A.length;

        int i = n - 1;
        while (i >= 0) {
            if (i != 0 && A[i] == A[i - 1]) {
                int cur = A[i];
                while (i >= 0 && A[i] == cur)
                    i--;
            } else
                return A[i];
        }

        return -1;
    }
}
