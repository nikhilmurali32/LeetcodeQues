class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key, value;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer, Node> hmap = new HashMap<>();
    Node head;
    Node tail;
    int n;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
        n=capacity;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)){
            return -1;
        }
        Node node = hmap.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(hmap.containsKey(key)){
            Node node1 = hmap.get(key);
            remove(node1);
        }
        if(hmap.size()==n){
            remove(tail.prev);
        }
        insert(node);
        hmap.put(key, node);
    }
    public void insert(Node node){
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev=node;
        hmap.put(node.key, node);
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        hmap.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */