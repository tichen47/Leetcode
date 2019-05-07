package hash_table;

import java.util.*;

public class Happy_Number_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            if (n == 1)
                return true;
            set.add(n);
            n = calculate(n);
        }
        return false;
    }

    public int calculate(int n) {
        int ret = 0;
        while (n > 0) {
            ret += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return ret;
    }
}
