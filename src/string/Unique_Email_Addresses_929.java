package string;

import java.util.*;

public class Unique_Email_Addresses_929 {
    /*
     * Solution: Without split
     * Time Complexity: O(N)  N: num of characters 
     * Space Complexity: O(N) 
     */ 
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for(i = 0;i < email.length();i++){
                char ch = email.charAt(i);
                
                if(ch == '@') break;
                else if(ch == '+'){ 
                    while(email.charAt(i) != '@') i++;
                    break;
                }
                else if(ch == '.') continue;
                
                sb.append(ch);
            }
            
            sb.append(email.substring(i, email.length()));
            set.add(sb.toString());
        }
        return set.size();
    }
    
    
    /*
     * Solution: With split
     * Time Complexity: O(N)  N: num of characters 
     * Space Complexity: O(N) 
     */
    public int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String[] sp = email.split("@"); 
            String[] valid = sp[0].split("\\+");
            set.add(valid[0].replace(".","") + "@" + sp[1]);
        }
        return set.size();
    }
}
