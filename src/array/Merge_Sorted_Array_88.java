package array;

public class Merge_Sorted_Array_88 {

    /*
     * Solution: Two pointer from end 
     * Time Complexity: O(N+M)
     * Space Complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m + n - 1; i >= 0; i--) {
            if (m <= 0)
                nums1[i] = nums2[--n];
            else if (n <= 0)
                nums1[i] = nums1[--m];
            else if (nums1[m - 1] > nums2[n - 1])
                nums1[i] = nums1[--m];
            else
                nums1[i] = nums2[--n];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m = 3, n = 3;

        Merge_Sorted_Array_88 merge = new Merge_Sorted_Array_88();
        merge.merge(nums1, m, nums2, n);
    }

}
