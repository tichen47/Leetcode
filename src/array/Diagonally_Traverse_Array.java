package array;

public class Diagonally_Traverse_Array {

    public void printArray(int[][] a){
        int n = a.length;

        for(int i = 0; i < 2 * n - 1; i++) {
            int min = Math.max(0, i - n + 1);
            int max = Math.min(n - 1, i);

            for(int j = min; j <= max; j++) {
                System.out.print(a[j][i-j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Diagonally_Traverse_Array d = new Diagonally_Traverse_Array();
        d.printArray(a);
    }
}
