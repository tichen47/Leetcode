package string;

public class Count_And_Say_38 {

    /*
     * Super misleading description
     */
    public String countAndSay(int n) {
        String ret = "1";
        if (n <= 1)
            return ret;

        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < ret.length(); j++) {
                if (ret.charAt(j) == ret.charAt(j - 1))
                    count++;
                else {
                    temp.append(count);
                    temp.append(ret.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(ret.charAt(ret.length() - 1));
            ret = temp.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        Count_And_Say_38 c = new Count_And_Say_38();
        c.countAndSay(5);
    }

}
