package math;

public class Armstrong_Number_5028 {
    public boolean isArmstrong(int N) {
        String num = String.valueOf(N);
        int len = num.length();
        
        for(int i = 0; i < len; i++){
            int digit = num.charAt(i) - '0';
            N -= Math.pow(digit,len);
        }
        return N == 0;
    }
}
