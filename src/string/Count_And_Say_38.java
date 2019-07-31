package string;

public class Count_And_Say_38 {

    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = nextString(res);
        }
        return res;
    }
    
    public String nextString(String cur){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < cur.length(); i++){
            if(cur.charAt(i) != cur.charAt(i-1)){
                sb.append(count).append(cur.charAt(i-1));
                count = 1;
            }
            else count++;
        }
        sb.append(count).append(cur.charAt(cur.length()-1));
        return sb.toString();
    }

}
