package math;

public class Largest_Time_for_Given_Digits_949 {
    public String largestTimeFromDigits(int[] A) {
        int maxMinutes = -1;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(i == j) continue;
                for(int k = 0; k < 4; k++) {
                    if(i == k || j == k) continue;
                    int l = 6 - i - j - k;
                    int curMinutes = isTimeValid(A[i], A[j], A[k], A[l]);
                    maxMinutes = Math.max(maxMinutes, curMinutes);
                }
            }
        }
        return maxMinutes == -1 ? "" : String.format("%2d:%2d", maxMinutes / 60, maxMinutes % 60).replaceAll("\\s","0");
    }

    private int isTimeValid(int a, int b, int c, int d) {
        int hours = a * 10 + b;
        int minutes = c * 10 + d;
        return hours < 24 && minutes < 60 ? hours * 60 + minutes : -1;
    }
}
