package greedy;

public class Previsou_Permutation_With_One_Swap {
    /*
     * Solution:
     * 1. Loop from right to left, find the first letter we can swap
     *    if the number is decreasing from right to left, we can not swap any number
     * 2. Once we find the left number to swap, we need to find the first largest possible number
     * 3. Important: first largest possible number
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */ 
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        int left = n - 2, right = n - 1;
        
        // Find left 
        while(left >= 0 && A[left] <= A[left+1]) left--;
        if(left < 0) return A;
        
        // Find right
        while(A[left] <= A[right]) right--; // Find largest
        while(A[right-1] == A[right]) right--; // Find first largest
        
        // Swap
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
        
        return A;
    }
}
