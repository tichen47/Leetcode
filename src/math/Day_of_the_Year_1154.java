package math;

public class Day_of_the_Year_1154 {
    public int dayOfYear(String date) {
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        int res = 0;
        for(int i = 0; i < month - 1; i++) {
            res += days[i];
        }
        res += day;
        if(month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            res++;
        return res;
    }
}
