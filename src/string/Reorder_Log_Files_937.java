package string;

import java.util.Arrays;
import java.util.Comparator;

public class Reorder_Log_Files_937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                int index1 = log1.indexOf(" ") + 1;
                int index2 = log2.indexOf(" ") + 1;
                char ch1 = log1.charAt(index1);
                char ch2 = log2.charAt(index2);

                if(Character.isDigit(ch1) && Character.isDigit(ch2)) return 0;
                if(!Character.isDigit(ch1) && Character.isDigit(ch2)) return -1;
                if(Character.isDigit(ch1) && !Character.isDigit(ch2)) return 1;

                String str1 = log1.substring(index1);
                String str2 = log2.substring(index2);
                return str1.equals(str2) ? log1.compareTo(log2) : str1.compareTo(str2);
            }
        });
        return logs;
    }
}
