package hash_table;

public class Queries_on_a_Permutation_With_Key_1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] ret = new int[queries.length];
        int[] map = new int[m+1]; // index : num,  value: position

        // initial
        for(int i = 1; i < m + 1; i++)
            map[i] = i - 1;

        for(int i = 0; i < queries.length; i++) {
            int pos = map[queries[i]];
            ret[i] = pos;

            for(int j = 1; j < m + 1; j++) {
                if(map[j] == pos)
                    map[j] = 0;
                else if(map[j] < pos)
                    map[j]++;
            }
        }
        return ret;
    }
}
