package greedy;

import java.util.*;

public class Assign_Cookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int v = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (v >= 0 && s[v] >= g[i]) {
                res++;
                v--;
            }
        }
        return res;
    }
}
