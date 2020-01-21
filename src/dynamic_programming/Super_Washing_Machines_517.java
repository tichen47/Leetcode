package dynamic_programming;

public class Super_Washing_Machines_517 {
    public int findMinMoves(int[] machines) {
        int n = 0, dresses = 0;
        for(int load : machines) {
            n++;
            dresses += load;
        }
        if(dresses % n != 0) return -1;

        int res = 0, cur = 0, avg = dresses / n;
        for(int load : machines) {
            cur += load - avg;

            // Math.abs(cur): throughput of every washer
            // load - avg: give out of every washer
            res = Math.max(Math.max(res, Math.abs(cur)), load - avg);
        }
        return res;
    }
}
