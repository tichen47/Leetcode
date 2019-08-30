package two_pointer;

import java.util.*;

public class Largest_Rectangle_in_Histogram_84 {
    /*
     * Solution: Brute Force
     * Time Complexity: O(N^3) : N * (N/2) * (N/2)
     * Space Complexity: O(1)
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int minH = Integer.MAX_VALUE;
                for(int k = j; k >= i; k--)
                    minH = Math.min(minH, heights[k]);
                maxArea = Math.max(maxArea, minH * (j - i + 1));
            }
        }
        return maxArea;
    }

    /*
     * Solution: Improve Brute Force
     * Time Complexity: O(N^2) : N * (N/2)
     * Space Complexity: O(1)
     */
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        for(int i = 0; i < len; i++) {
            int minH = Integer.MAX_VALUE;
            for(int j = i; j < len; j++) {
                minH = Math.min(minH, heights[j]);
                maxArea = Math.max(maxArea, minH * (j - i + 1));
            }
        }
        return maxArea;
    }

    /*
     * Solution: Devide and Conquer
     * Time Complexity: Average O(NlogN), Worst O(N^2)
     * Space Complexity: Average O(logN), Worst O(N) : recursive stack
     * Worst case occurs when the array is sorted
     * This solution can be improved by segment tree
     */
    public int largestRectangleArea3(int[] heights) {
        return devideAndConquer(heights, 0, heights.length - 1);
    }

    public int devideAndConquer(int[] heights, int left, int right) {
        int width = right - left + 1;
        if(width < 1) return 0;
        else if(width == 1) return heights[left];

        int minIndex = left;
        for(int i = left + 1; i <= right; i++) {
            if(heights[i] < heights[minIndex])
                minIndex = i;
        }

        int cur = width * heights[minIndex];
        int lMax = devideAndConquer(heights, left, minIndex - 1);
        int rMax = devideAndConquer(heights, minIndex + 1, right);
        return Math.max(cur, Math.max(lMax, rMax));
    }

    /*
     * Solution: Stack
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int largestRectangleArea4(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));

            stack.push(i);
        }
        while(stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxArea;
    }
}
