class MyLinkedList {

    private int val;
    private MyLinkedList next;
    private MyLinkedList head;
    private int length;
    
    public MyLinkedList() {
        length = 0;
    }

    public MyLinkedList(int val) {
        this.val = val;
    }

    public MyLinkedList(int val, MyLinkedList next) {
        this.val = val;
        this.next = next;
    }
    
    public int get(int index) {
        if (index > length - 1 || index < 0) return -1;
        int i = 0;
        MyLinkedList p = head;
        while (i < index) {
            p = p.next;
            i++;
        }
        return p.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList p = new MyLinkedList(val);
        if (head == null) {
            head = p;
        }
        else {
            p.next = head;
            head = p;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        MyLinkedList p = head;
        while (p.next != null)
            p = p.next;
        p.next = new MyLinkedList(val);
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) addAtHead(val);
        else if (index > length) return;
        else if (index == length) addAtTail(val);
        else {
            int i = 0;
            MyLinkedList p = head;
            while (i < index - 1) {
                p = p.next;
                i++;
            }
            MyLinkedList temp = new MyLinkedList(val, p.next);
            p.next = temp;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index > length - 1 || index < 0) return;
        if (index == 0) {
            head = head.next;
        }
        else {
            int i = 0;
            MyLinkedList p = head;
            while (i < index - 1) {
                p = p.next;
                i++;
            }
            p.next = p.next.next;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */