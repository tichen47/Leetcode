package stack;

import java.util.*;

public class Decode_String_394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> resStack = new LinkedList<>();
        int num = 0;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            else if(ch == '[') {
                numStack.push(num);
                resStack.push(res);
                num = 0;
                res = new StringBuilder();
            }
            else if(ch == ']') {
                StringBuilder temp = resStack.pop();
                for(int k = numStack.pop(); k > 0; k--)
                    temp.append(res);
                res = temp;
            }
            else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
