package math;

public class Number_of_Days_in_a_Month_1118 {
    public int numberOfDays(int Y, int M) {
        if(Y % 4 == 0 && M == 2){
            if(Y % 100 == 0 && Y % 400 != 0) return 28;
            return 29;
        }
        
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[M-1];
    }
}
