package array;

import java.util.*;

public class Relative_Sort_Array_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(int i = 0; i < arr2.length; i++){
            int key = arr2[i];
            int time = map.getOrDefault(key, 0);
            for(int j = 0; j < time; j++){
                ans[index++] = key;
                map.remove(key);
            }
        }
        
        int sortPos = index;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++)
                ans[index++] = entry.getKey();
        }
        
        Arrays.sort(ans, sortPos, ans.length);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = new int[] {2,42,38,0,43,21};
        Relative_Sort_Array_1122 r = new Relative_Sort_Array_1122();
        int[] ans = r.relativeSortArray(arr1, arr2);
        System.out.println();
        for(int num : ans)
            System.out.print(num + " ");
    }
}
