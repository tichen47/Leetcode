package hash_table;

import java.util.*;

public class Insert_Delete_GetRandom_380 {
    Random rand;
    Map<Integer, Integer> map;
    List<Integer> ls;
    int count;

    /** Initialize your data structure here. */
    public Insert_Delete_GetRandom_380() {
        rand = new Random();
        map = new HashMap<>();
        ls = new ArrayList<>();
        count = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, count);
        ls.add(val);
        count++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);

        if(index < count - 1) {
            int last = ls.get(count - 1);
            ls.set(index, last);
            map.put(last, index);
        }

        ls.remove(count - 1);
        map.remove(val);
        count--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return ls.get(rand.nextInt(count));
    }
}
