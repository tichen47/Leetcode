package string;

public class Compare_Version_Numbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.max(len1, len2);
        
        for(int i = 0; i < len; i++){
            int cur1 = i < len1 ? Integer.valueOf(v1[i]) : 0;
            int cur2 = i < len2 ? Integer.valueOf(v2[i]) : 0;
            if(cur1 > cur2) return 1;
            else if(cur1 < cur2) return -1;
        }
        return 0;
    }
}
