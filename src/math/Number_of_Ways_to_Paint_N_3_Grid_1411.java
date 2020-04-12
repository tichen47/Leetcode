package math;

public class Number_of_Ways_to_Paint_N_3_Grid_1411 {
    public int numOfWays(int n) {
        int mod = (int)1e9 + 7;
        if(n == 1) return 12;
        if(n == 2) return 54;
        int t1 = 30;
        int t2 = 24;
        for(int i = 3; i <= n; i++) {
            int temp1 = ((t1 + t1) % mod + t1) % mod + (t2 * 2) % mod;
            int temp2 = (t1 * 2) % mod + (t2 * 2) % mod;
            t1 = temp1 % mod;
            t2 = temp2 % mod;
        }
        return (t1 + t2) % mod;
    }
}
