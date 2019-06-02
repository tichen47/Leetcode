package string;

public class Greatest_Common_Divisor_of_Strings_1071 {
    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null) return "";
        
        // Make sure str1 is shorter
        if(str1.length() > str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        
        String ret = "";
        for(int i = 1; i <= len1; i++){
            if(i == len1 || str1.charAt(i) == str1.charAt(0)){
                String sub = str1.substring(0, i);
                if(sub.length() > ret.length() && isCommonDivisor(str1, str2, sub, len1, len2))
                    ret = sub;
            }
        }
        return ret;
    }
    
    public boolean isCommonDivisor(String str1, String str2, String sub, int len1, int len2){
        if(len1 % sub.length() != 0 || len2 % sub.length() != 0) return false;

        String temp = "";
        while(temp.length() < len1) 
            temp += sub;
        if(!str1.equals(temp)) return false;
        
        while(temp.length() < len2)
            temp += sub;
        return str2.equals(temp);
    }
}
