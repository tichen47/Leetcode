package string;

public class Repeated_Substring_Pattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);
        return ss.contains(s);
    }
}
