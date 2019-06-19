package search;

public class Median_of_Two_Sorted_Array_4 {
    /*
     * Solution: 
     * Time Complexity: O(log(min(m, n))) 
     * Space Complexity: O(1)
     */
    public double findMedianSortedArrays(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        
        // Ensure m <= n
        if(m > n){
            int[] temp = A; A = B; B = temp;
            int t = m; m = n; n = t;
        }
        
        // Binary Search in A[l,r)
        int iMin = 0; int iMax = m; 
        int half = (m + n + 1) / 2; // Partition length: len(LeftA + LeftB) = len(RightA + RightB) + (0 or 1) 
        
        while(iMin <= iMax){
            int i = (iMin + iMax) / 2;  // LeftA[0,i), RightA[i, m)
            int j = half - i;           // LeftB[0,j), RightB[j, n)
            
            if(i > iMin && A[i - 1] > B[j])
                iMax = i - 1;
            else if(i < iMax && A[i] < B[j-1])
                iMin = i + 1;
            else{
                int maxLeft = 0;
                if(i == 0) maxLeft = B[j-1];
                else if(j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);
                
                if((m + n) % 2 == 1) return maxLeft;
                
                int minRight = 0;
                if(i == m) minRight = B[j];
                else if(j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);
                
                return (minRight + maxLeft) / 2.0;
            }
        }
        
        return 0.0;
    }
}
