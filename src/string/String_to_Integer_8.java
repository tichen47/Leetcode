package string;

public class String_to_Integer_8 {
    public int myAtoi(String str) {
        int sign = 1, i = 0, num = 0, len = str.length();
        
        char[] arr = str.toCharArray();
        
        // Remove Empty Space
        while(i < len && arr[i] == ' ') i++;
        
        // Sign
        if(i < len && (arr[i] == '+' || arr[i] == '-'))
            sign = arr[i++] == '+' ? 1 : -1;
        
        // Overflow and character
        int bound = Integer.MAX_VALUE / 10;
        int bound_digit = Integer.MAX_VALUE % 10;
        
        while(i < len){
            int digit = arr[i] - '0';
            if(digit < 0 || digit > 9) break;
            
            // Overflow
            if(num > bound || (num == bound && digit > bound_digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}
