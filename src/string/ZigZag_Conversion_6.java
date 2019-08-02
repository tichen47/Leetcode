package string;

public class ZigZag_Conversion_6 {
    /*
     * Solution: Sort by Row
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */ 
    public String convert(String s, int numRows) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder();
        
        int idx = 0;
        while(idx < n){
            for(int i = 0; i < numRows && idx < n; i++)
                sbs[i].append(arr[idx++]);
            for(int i = numRows - 2; i >= 1 && idx < n; i--)
                sbs[i].append(arr[idx++]);
        }
        String ret = "";
        for(int i = 0; i < sbs.length; i++)
            ret += sbs[i].toString();
        return ret;
    }
    
    /*
     * Solution: Visit by Row
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */ 
    public String convert2(String s, int numRows) {
        if(numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int diff = 2 * numRows - 2;  // diff = 0 if numRows = 1
        
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j + i < n; j += diff){ // j : num of cycle
                sb.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + diff - i < n)
                    sb.append(s.charAt(j + diff - i));
            }
        }
        return sb.toString();
    }
}
