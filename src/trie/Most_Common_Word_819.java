package trie;

import java.util.*;

public class Most_Common_Word_819 {
    // Can use char[26] instead of map to save space
    class TreeNode {
        int count;
        boolean isBan;
        Map<Character, TreeNode> map;
        public TreeNode(){
            count = 0;
            isBan = false;
            map = new HashMap<>();
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word, boolean isBan) {
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!cur.map.containsKey(ch))
                cur.map.put(ch, new TreeNode());
            cur = cur.map.get(ch);
        }
        if(isBan) cur.isBan = true;
        if(cur.isBan) return;

        cur.count++;
        // System.out.println(word + " " + cur.count);
        if(cur.count > maxCount) {
            mostFreqWord = word;
            maxCount = cur.count;
        }
    }

    TreeNode root;
    String mostFreqWord;
    int maxCount;
    public String mostCommonWord(String paragraph, String[] banned) {
        root = new TreeNode();
        mostFreqWord = "";
        maxCount = 0;
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String word : banned)
            insert(word, true);

        for(String word : words)
            insert(word, false);

        return mostFreqWord;
    }
}
