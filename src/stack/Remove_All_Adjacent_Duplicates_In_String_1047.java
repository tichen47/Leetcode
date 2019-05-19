package stack;

import java.util.*;

public class Remove_All_Adjacent_Duplicates_In_String_1047 {
    
    /*
     * Solution: Stack
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String removeDuplicates(String S) {
        if(S == null || S.length() < 2) return S;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(!stack.isEmpty() && stack.peek() == S.charAt(i))
                stack.pop();
            else
                stack.push(S.charAt(i));
        }
        
        String ret = "";
        while(!stack.isEmpty()) 
            ret = stack.pop() + ret;
        return ret;
    }
    
    /*
     * Solution: Ugly two pointer
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String removeDuplicates2(String S) {
        if(S.length() < 2) return S;
        char[] array = S.toCharArray();
        int n = array.length;
        int l = 0;
        int r = 1;
        while(r < n){
            while(l < n - 1 && array[l] == '*') l++;
            r = l+1;
            while(r < n && array[r] == '*') r++;
            if(r == n) break;
            else if(array[l] == array[r]){
                array[l] = '*';
                array[r] = '*';
                while(l > 0 && array[l] == '*') l--;
                if(r < n-1) r++;
                while(l > 0 && r < n-1 && array[l] == array[r]){
                    array[l] = '*';
                    array[r] = '*';
                    while(l > 0 && array[l] == '*') l--;
                    if(r < n-1) r++;
                }
            }
            else{
                l++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(array[i] != '*')
                sb.append(array[i]);
        }
        return sb.toString();
    }
    
    
}
