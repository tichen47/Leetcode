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

    /*
     * Solution: Sort
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * In quick sort, we need to do recursion in each part
     * but in quick select, we can throw the one of the part and do the recursion in the rest of the part.
     * Therefore, the time complexity of quick select is
     * T(t) = 2T(t) - T(t) = c(2n + n + n/2 + n/4 + ... + 2) - c *(n + n/2 + n/4 + n/8 + ... + 1) = 2cn -1 = O(n).
     */
    public int[][] kClosest3(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        while(left < right) {
            int m = helper(points, left, right);
            if(m > K) right = m;
            else left = m + 1;
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    public int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while(l < r) {
            while(l < r && getDistance(pivot) <= getDistance(points[r])) r--;
            points[l] = points[r];
            while(l < r && getDistance(pivot) > getDistance(points[l])) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
}
