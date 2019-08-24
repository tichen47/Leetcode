package trie;

import java.util.*;

public class FileSystem {
    // Problem 1166
    Node root;

    public FileSystem() {
        root = new Node();
        root.map.put("", new Node());
    }

    public boolean create(String path, int value) {
        Node cur = root;
        String[] paths = path.split("/");
        for(int i = 0; i < paths.length - 1; i++){
            if(!cur.map.containsKey(paths[i])) return false;
            cur = cur.map.get(paths[i]);
        }
        String last = paths[paths.length - 1];
        if(cur.map.containsKey(last)) return false;
        cur.map.put(last, new Node());
        cur = cur.map.get(last);
        cur.value = value;
        return true;
    }

    public int get(String path) {
        Node cur = root;
        String[] paths = path.split("/");
        for(int i = 0; i < paths.length; i++){
            if(!cur.map.containsKey(paths[i])) return -1;
            cur = cur.map.get(paths[i]);
        }
        return cur.value;
    }

    class Node {
        int value;
        Map<String, Node> map;
        public Node() {
            value = -1;
            map = new HashMap<>();
        }
    }
}
