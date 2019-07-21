package hash_table;

import java.util.*;

public class Number_of_Equivalent_Domino_Pairs_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int[] dom : dominoes){
            String key = dom[0] < dom[1] ? "" + dom[0] + dom[1] : "" + dom[1] + dom[0]; 
            int count = map.getOrDefault(key, 0);
            total += count;
            map.put(key, count + 1);
        }
        return total;
    }

    
    public static void main(String[] args) {
        int[][] dominoes = new int[][] {{1,2},{2,1},{3,4},{5,6}};
        Number_of_Equivalent_Domino_Pairs_1128 n = new Number_of_Equivalent_Domino_Pairs_1128();
        System.out.println(n.numEquivDominoPairs(dominoes));
    }
}
