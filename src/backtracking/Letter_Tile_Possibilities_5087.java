package backtracking;

import java.util.*;

public class Letter_Tile_Possibilities_5087 {
    /*
     * Similar to Permutation II
     */
    Set<String> set;
    
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        backTracking(tiles.toCharArray(), 0, tiles.length());
        return set.size();
    }
    
    public void backTracking(char[] arr, int index, int len){
        if(index > 0)
            set.add(String.valueOf(Arrays.copyOf(arr, index)));
        
        for(int i = index; i < len; i++){
            swap(arr, i, index);
            backTracking(arr, index+1, len);
            swap(arr, i, index);
        }
    }
    
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
