import java.util.*;

class LRUCache {
    // 双向链表，内部类
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {this.key = key; this.value = value;}
    }
    private int capacity, size;
    private HashMap<Integer, DLinkedNode> index = new HashMap<>();
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLinkedNode(); // 伪头节点
        tail = new DLinkedNode(); // 伪尾结点
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (index.containsKey(key)) {
            // 找到该结点在链表中的位置
            DLinkedNode temp = index.get(key);
            // 删除当前结点
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            // 将当前结点转到头部
            temp.next = head.next;
            temp.prev = head;
            head.next.prev = temp;
            head.next = temp;
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DLinkedNode temp;
        // 如果满了，则删除最后一个节点
        if (size == capacity && !index.containsKey(key)) {
            size--;
            temp = tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;
            index.remove(temp.key); // 从哈希表中移除该结点
        }
        if (index.containsKey(key)) {
            // 找到该结点在链表中的位置并更新值
            temp = index.get(key);
            temp.value = value;
            // 删除当前结点
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        else {
            temp = new DLinkedNode(key, value);
            size++;
        }
        // 将当前结点转到头部
        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;
        index.put(key, temp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */