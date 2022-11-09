import java.util.*;

class LRU {

    class DListNode {
        private int key;
        private int value;
        private DListNode prev;
        private DListNode next;

        public DListNode() {}

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DListNode(int key, int value, DListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public DListNode(int key, int value, DListNode prev, DListNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int capacity;
    private DListNode head, tail;
    private Map<Integer, DListNode> map = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new DListNode(); // 哨兵头结点
        tail = new DListNode(); // 哨兵尾结点
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DListNode temp = map.get(key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;
        return temp.value;
    }
    
    public void put(int key, int value) {
        // 缓存已满
        if (map.size() >= capacity && !map.containsKey(key)) {
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = null;
            tail.prev.next = tail;
        }
        // 缓存未满
        if (map.containsKey(key)) {
            // 释放当前结点
            DListNode temp = map.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp = null;
        }
        // 生成新节点并放在最前面
        DListNode newNode = new DListNode(key, value, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */