package array;

import java.util.*;

public class Number_of_Matching_Subsequences_792 {
    /*
     * Solution: straight forward
     * Time Complexity:  O(|S| + ∑|wordi|)
     * Space Complexity: O(N)
     */
    public int numMatchingSubseq(String S, String[] words) {
        // Integer[0]: index of word in words[]
        // Integer[1]: index of current waiting character
        // Reason for using 128: 'a' - 'z' converting to ASCII is 97-122
        List<Integer[]>[] waiting = new List[128];

        // Initial all the waiting list
        waiting[0] = new ArrayList<>(); // store finished word
        for(int i = 'a'; i <= 'z'; i++)
            waiting[i] = new ArrayList<>();

        // Store words in waiting
        for(int i = 0; i < words.length; i++) {
            char start = words[i].charAt(0);
            waiting[start].add(new Integer[]{i, 1});
        }

        // Scan through the S
        for(char c : S.toCharArray()) {
            List<Integer[]> process = new ArrayList<>(waiting[c]);
            waiting[c].clear();
            for(Integer[] pair : process) {
                String word = words[pair[0]];
                waiting[pair[1] < word.length() ? word.charAt(pair[1]++) : 0].add(pair);
            }
        }
        return waiting[0].size(); // Can use a counter to instead
    }
}
