package hash_table;

import java.util.*;

public class Intersection_of_Two_Arrays_349 {
    /* 
     * TreeSet can be used for imporving
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ret.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        return ret.stream().mapToInt(i -> i).toArray();
    }
}
