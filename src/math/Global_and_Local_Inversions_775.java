package math;

public class Global_and_Local_Inversions_775 {
    public boolean isIdealPermutation(int[] A) {
        int preMax = A[0];
        for(int i = 2; i < A.length; i++) {
            if(A[i] < preMax) return false;
            preMax = Math.max(preMax, A[i-1]);
        }
        return true;
    }
}
