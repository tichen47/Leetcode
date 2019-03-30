package math;

import java.util.*;

public class Roman_To_Integer_13 {
    
    /*
     * Solution: 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int sum = 0;
        int cur;
        
        for(int i = 0; i < s.length(); i++){
            cur = map.get(s.charAt(i));
            if(i == s.length() - 1  || cur >= map.get(s.charAt(i+1)))
                sum += cur;
            else
                sum -= cur;
        }
        return sum;
    }
}
