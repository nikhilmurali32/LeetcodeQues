class LRUCache {
    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value){
            this.key=_key;
            this.value=_value;
        }
    }
    HashMap<Integer, Node> hmap = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    public LRUCache(int _capacity) {
        capacity=_capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)){
            return -1;
        }
        Node node=hmap.get(key);
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
        if(hmap.size()==capacity){
            remove(tail.prev);
        }
        insert(node);
    }
    public void insert(Node node){
        // Node node = hmap.get(key);
        hmap.put(node.key, node);
        Node temp=head.next;
        head.next=node;
        node.next=temp;
        node.prev=head;
        temp.prev=node;
    }
    public void remove(Node node){
        // Node node = hmap.get(key);
        hmap.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */