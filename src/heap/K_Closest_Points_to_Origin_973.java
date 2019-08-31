package heap;

import java.util.*;

public class K_Closest_Points_to_Origin_973 {

    public int getDistance(int[] pos) {
        return pos[0] * pos[0] + pos[1] * pos[1];
    }

    /*
     * Solution: Sort
     * Time Complexity: O(N * logN)
     * Space Complexity: O(1)
     */
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> getDistance(p1) - getDistance(p2));
        return Arrays.copyOfRange(points, 0, K);
    }

    /*
     * Solution: Heap
     * Time Complexity: O(NlogK) : logK for inserting in the heap
     * Space Complexity: O(K)
     */
    public int[][] kClosest2(int[][] points, int K) {
        // Using lambda will be much slower than rewrite Comparator class
        // Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> getDistance(p2) - getDistance(p1));
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return getDistance(p2) - getDistance(p1);
            }
        });

        for(int[] point : points) {
            pq.add(point);
            if(pq.size() > K)
                pq.remove();
        }

        int[][] res = new int[K][2];
        while(K > 0)
            res[--K] = pq.remove();

        return res;
    }

    // Solution: Quick Select need to be implemented
}
