package hash_table;

import java.util.*;

public class Copy_List_With_Random_Variable_138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {

        // Key: origin node, Value: new node
        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node();
        dummy.next = head;
        Node newDummy = new Node();

        Node it1 = dummy;
        Node it2 = newDummy;

        while(it1 != null) {
            Node originN = it1.next;
            if(originN != null) {
                if(!map.containsKey(originN))
                    map.put(originN, new Node(originN.val, null, null));

                it2.next = map.get(originN);
            }

            Node randomN = it1.random;
            if(randomN != null) {
                if(!map.containsKey(randomN))
                    map.put(randomN, new Node(randomN.val, null, null));

                it2.random = map.get(randomN);
            }

            it1 = it1.next;
            it2 = it2.next;
        }

        return newDummy.next;
    }
}
