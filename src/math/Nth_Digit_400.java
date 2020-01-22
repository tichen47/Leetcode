package math;

public class Nth_Digit_400 {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while(n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        int num = start + (n - 1) / len;
        String s = String.valueOf(num);
        return s.charAt((n - 1) % len) - '0';
    }
}
