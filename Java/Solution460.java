import java.util.*;

class LFUCache {

    // 双向链表结点
    class DoubleListNode {
        private int key;
        private int value;
        private int count;
        private DoubleListNode prev;
        private DoubleListNode next;

        public DoubleListNode() {}

        public DoubleListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    // 双向链表
    class DoubleLinkedList {
        private DoubleListNode head; // 哨兵头节点
        private DoubleListNode tail; // 哨兵尾节点
        int size;

        public DoubleLinkedList() {
            this.head = new DoubleListNode();
            this.tail = new DoubleListNode();
            this.size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(DoubleListNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public int removeLast() {
            int res = tail.prev.key;
            if (tail.prev != head) {
                tail.prev = tail.prev.prev;
                tail.prev.next = null;
                tail.prev.next = tail;
                size--;
            }
            return res;
        }

        public void remove(DoubleListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

    }

    private Map<Integer, DoubleLinkedList> freMap;
    private Map<Integer, DoubleListNode> map;
    private int capacity;
    private int minNum;

    public LFUCache(int capacity) {
        this.freMap = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.minNum = 1;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode temp = map.get(key);
        // 从当前链移除temp结点
        freMap.get(temp.count).remove(temp);
        // 更新最小次数
        if (freMap.get(temp.count).size == 0) {
            if (minNum == temp.count) {
                minNum++;
            }
        }

        // 将temp结点放到次数为cnt + 1 的链表中
        temp.count++;
        if (!freMap.containsKey(temp.count)) {
            freMap.put(temp.count, new DoubleLinkedList());
        }
        freMap.get(temp.count).addFirst(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        // 特例
        if (capacity == 0) {
            return;
        }
        // 缓存已满
        if (map.size() >= capacity && !map.containsKey(key)) {
            int x = freMap.get(minNum).removeLast();
            map.remove(x);
        }
        // 缓存未满
        DoubleListNode temp = null;
        if (map.containsKey(key)) {
            temp = map.get(key);
            // 从当前链移除temp结点
            freMap.get(temp.count).remove(temp);
            // 更新最小次数
            if (freMap.get(temp.count).size == 0) {
                if (minNum == temp.count) {
                    minNum++;
                }
            }
            temp.value = value;
            temp.count++;
        } else {
            temp = new DoubleListNode(key, value);
            minNum = 1;
        }
        // 将temp放到次数为cnt + 1 的链表中
        if (!freMap.containsKey(temp.count)) {
            freMap.put(temp.count, new DoubleLinkedList());
        }
        freMap.get(temp.count).addFirst(temp);
        map.put(key, temp);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */