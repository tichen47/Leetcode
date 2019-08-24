package hash_table;

import java.util.*;

public class Single_Row_Keyboard_1165 {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++)
            map.put(keyboard.charAt(i) , i);
        int cur = 0;
        int sum = 0;
        for(int i = 0; i < word.length(); i++){
            int next = map.get(word.charAt(i));
            System.out.println(next);
            sum += Math.abs(next - cur);
            cur = next;
        }
        return sum;
    }

    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        System.out.println(new Single_Row_Keyboard_1165().calculateTime(keyboard, word));
    }
}
