package math;

public class N_th_Tribonacci_Number_1137 {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for(int i = 3; i <= n; i++){
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return c;
    }
}
