import java.util.HashMap;

/**
 * Created by adamli on 10/30/15.
 */
public class LRU_Cache {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    // the "outside" node which represent node can be poped
    Node head = null;

    // the "inside" cursor which represents the newest node
    Node tail = null;

    int capacity;

    // @param capacity, an integer
    public LRU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public void remove_from_list(Node curr) {
        Node prev = curr.prev;
        Node next = curr.next;

        /**
         * if prev = null, curr = tail
         */
        if (prev == null) {
            tail = tail.next;
        }else {
            prev.next = curr.next;
        }

        /**
         * if next = null, curr = head
         */
        if (next == null) {
            head = head.prev;
        }else {
            next.prev = curr.prev;
        }
    }

    public void add_to_tail(Node curr) {
        // connect curr behind tail
        curr.next = tail;
        curr.prev = null;

        // if tail exists
        if (tail != null) {
            tail.prev = curr;
            tail = tail.prev;
        }else{
            /**
             * since we add curr to tail when there is only one node
             * there is no need to worry about head.prev when there
             * is only one node
             */
            tail = curr;
        }

        // if head is null, then there is one node only
        // head = tail = curr
        if (head == null)
            head = tail;
    }

    // @return an integer
    public int get(int key) {
        if (map.containsKey(key)) {
            // if key already exists
            // remove it
            // then add it into tail
            // and return value
            Node tmp = map.get(key);
            remove_from_list(tmp);
            add_to_tail(tmp);

            return tmp.value;
        }

        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            /**
             * if key already exists
             * update current node with new value
             * remove it
             * and add it back into tail
             */
            Node existing = map.get(key);
            existing.value = value;
            remove_from_list(existing);
            add_to_tail(existing);

            return;
        }else{
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(head.key);
                remove_from_list(head);
            }

            // add new node into tail
            add_to_tail(newNode);
            // add new entry into map
            map.put(key, newNode);
        }
    }

    public static void main(String args[]) {
        int capacity = 2;
        LRU_Cache sol = new LRU_Cache(capacity);

        sol.set(2,1);
        sol.set(1,1);
        sol.get(2);
        sol.set(4,1);
        sol.get(1);
        sol.get(2);
    }
}

class Node {
    Node prev = null;
    Node next = null;
    int value;
    int key;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
