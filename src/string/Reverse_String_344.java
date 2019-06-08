package string;

public class Reverse_String_344 {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;
        int left = 0, right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
