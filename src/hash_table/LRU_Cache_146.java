package hash_table;

import java.util.*;

public class LRU_Cache_146 {

    class ListNode {
        int key, value;
        ListNode prev, next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            ListNode prev = null;
            ListNode next = null;
        }
    }

    private void addNode(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        cache.put(node.key, node);
        size++;
    }

    private void removeNode(ListNode node) {
        if(size <= 0) return;
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;

        cache.remove(node.key);
        size--;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    private Map<Integer, ListNode> cache;
    private ListNode head, tail;
    private int size;
    private int capacity;

    public LRU_Cache_146(int capacity) {
        cache = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        this.capacity = capacity;
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            ListNode node = new ListNode(key, value);
            addNode(node);

            if(size > capacity)
                removeNode(tail.prev);
        } else {
            ListNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

}
