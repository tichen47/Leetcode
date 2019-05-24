package backtracking;

import java.util.*;

public class Combinations_77 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(C(N,K)) => O(n^min{k,n-k})
     * Space Complexity: O(C(N,K)) 
     */ 
    List<List<Integer>> ret;
    List<Integer> path;
    
    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        combine(n, k, 1);
        return ret;
    }
    
    public void combine(int n, int k, int start){
        if(k == 0){
            ret.add(new ArrayList<>(path));
            return;
        }
        
        // use (i+k-1 <= n) instead of (i <= n), save a lot of time
        for(int i = start; i + k - 1 <= n; i++){  
            path.add(i);
            combine(n, k-1, i+1);
            path.remove(path.size()-1);
        }
    }
}
