package search;

public class Search_a_2D_Matrix_74 {
    
    /*
     * Solution: One Binary Search
     * Treat as one list
     * Time Complexity: O(log(N * M))
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int col = matrix[0].length;
        int left = 0, right = matrix.length * col - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(matrix[mid/col][mid%col] == target) return true;
            else if(matrix[mid/col][mid%col] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    
    /*
     * Solution: Two Binary Search
     * Treat as matrix
     * Time Complexity: O(logN + logM)
     * Space Complexity: O(1)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int h = searchHeight(matrix, target);
        return searchIndex(matrix, target, h);
    }
    
    public int searchHeight(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) return -1;
        int lo = 0, hi = matrix.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(matrix[mid][0] == target) return mid;
            else if(matrix[mid][0] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return hi;
    }
    
    public boolean searchIndex(int[][] matrix, int target, int height){
        if(height == -1) return false;
        int left = 0, right = matrix[0].length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[height][mid] == target) return true;
            else if(matrix[height][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
