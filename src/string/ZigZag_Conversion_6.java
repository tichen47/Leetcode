package string;

public class ZigZag_Conversion_6 {
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
}
