package hash_table;

import java.util.*;

public class Number_of_Boomerangs_447 {

    /*
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */
    public int numberOfBoomerangs(int[][] points) {
        // Key: distance, Value: frequency
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                // Avoid double value, use square of distance instead
                int distance = dis(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (Integer freq : map.values()) {
                ret += freq * (freq - 1);
            }
            map.clear();
        }
        return ret;
    }

    public int dis(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Number_of_Boomerangs_447 n = new Number_of_Boomerangs_447();
        System.out.println(n.numberOfBoomerangs(test));
    }

}
