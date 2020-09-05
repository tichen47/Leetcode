package greedy;

import java.util.*;

public class Partition_Labels_763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];  // last index of each character
        for(int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int end = 0;     // end index of current substring
        int start = 0;   // start index of current substring
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
