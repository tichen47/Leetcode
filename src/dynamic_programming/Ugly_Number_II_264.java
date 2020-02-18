package dynamic_programming;

public class Ugly_Number_II_264 {
    /*
     * Solution 1: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++) {
            num[i] = Math.min(num[index2] * 2, Math.min(num[index3] * 3, num[index5] * 5));
            if(num[i] == num[index2] * 2) index2++;
            if(num[i] == num[index3] * 3) index3++;
            if(num[i] == num[index5] * 5) index5++;
        }
        return num[n - 1];
    }
}
