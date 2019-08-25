package hash_table;

public class Design_HashTable_706 {
    class MyHashMap {
        final int len = 10000;
        ListNode[] buckets;

        /** Initialize your data structure here. */
        public MyHashMap() {
            buckets = new ListNode[len];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = hash(key);
            if(buckets[idx] == null)
                buckets[idx] = new ListNode(-1, -1);
            ListNode pre = findPre(key, idx);
            if(pre.next == null)
                pre.next = new ListNode(key, value);
            else
                pre.next.value = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = hash(key);
            if(buckets[idx] == null) return -1;
            ListNode pre = findPre(key, idx);
            return pre.next == null ? -1 : pre.next.value;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = hash(key);
            ListNode cur = buckets[idx];
            while(cur != null && cur.next != null){
                if(cur.next.key == key)
                    cur.next = cur.next.next;
                cur = cur.next;
            }
        }

        public int hash(int key) {
            return Integer.hashCode(key) % len;
        }

        public ListNode findPre(int key, int idx) {
            ListNode pre = buckets[idx];
            if(pre == null) return pre;
            while(pre.next != null && pre.next.key != key)
                pre = pre.next;
            return pre;
        }

        class ListNode {
            int key;
            int value;
            ListNode next;
            public ListNode (int key, int value) {
                this.key = key;
                this.value = value;
                next = null;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
