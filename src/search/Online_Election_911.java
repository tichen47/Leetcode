package search;

import java.util.*;

public class Online_Election_911 {

    List<List<Vote>> A; // A[i] is a list of votes with i-th count
    public Online_Election_911(int[] persons, int[] times) {
        A = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < persons.length; i++) {
            int p = persons[i], t = times[i];
            int c = map.getOrDefault(p, -1) + 1;

            map.put(p, c);
            if (A.size() == c)
                A.add(new ArrayList<Vote>());
            A.get(c).add(new Vote(p, t));
        }
    }

    public int q(int t) {
        // Find the biggest i such that A[i][0].time < t
        int l = 0, r = A.size() - 1;
        while(l < r) {
            int mid = (l + r + 1) / 2;
            if (A.get(mid).get(0).time <= t)
                l = mid;
            else
                r = mid - 1;
        }
        int i = l;

        // Find the biggest j such that A[i][j].time < t
        l = 0;
        r = A.get(i).size() - 1;
        while(l < r) {
            int mid = (l + r + 1) / 2;
            if(A.get(i).get(mid).time <= t)
                l = mid;
            else
                r = mid - 1;
        }

        return A.get(i).get(l).person;
    }

    class Vote {
        int person, time;
        Vote(int p, int t) {
            person = p;
            time = t;
        }
    }
}
