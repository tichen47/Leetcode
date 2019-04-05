package string;

public class Length_Of_Last_Word_58 {

    /*
     * Solution: Without build-in function
     * Time Complexity: O(N*2)
     * Space Complexity: O(N)
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int n;
        for(n=s.length()-1; n>=0; n--){
            if(s.charAt(n) != ' ')
                break;
        }
        
        for(int i=n; i>=0; i--){
            if(s.charAt(i) == ' ')
                return length;
            length++;
        }
        return length;
    }
    
    /*
     * Boring solution with build-in function
     */
    public int lengthOfLastWord2(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
