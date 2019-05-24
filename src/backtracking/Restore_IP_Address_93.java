package backtracking;

import java.util.*;

public class Restore_IP_Address_93 {
    /*
     * Solution: DFS backtracking
     * Time Complexity: O(3^4) 
     * Space Complexity: O(19) No more than 19 valid IP addresses
     */ 
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
    
        restoreIpAddresses(ret, "", 0, 1, s);
        return ret;
    }
    
    public void restoreIpAddresses(List<String> ret, String path, int index, int part, String s){
        if(part == 4){
            String last = s.substring(index);
            if(valid(last)) ret.add(path+last);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(index + i + (4 - part) >= s.length()) break;
            String ip = s.substring(index, index + i + 1);
            if(valid(ip))
                restoreIpAddresses(ret, path + ip + ".", index + i + 1, part + 1, s);
        }
    }
    
    /*
     * Check if the current segment is valid :
     * 1. less or equal to 255      
     * 2. the first character could be '0' 
     * only if the segment is equal to '0'
     */
    public boolean valid(String address){
        if(address.length() == 1) return true;
        if(address.length() > 3 || address.charAt(0) == '0') return false;
        
        return Integer.valueOf(address) <= 255;
    }
}
