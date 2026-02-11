class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key, value;
        Node(int key, int value){
            // this.prev=prev;
            // this.next=next;
            this.key=key;
            this.value=value;
        }
    }
    int n;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    HashMap<Integer, Node> hmap;
    public LRUCache(int capacity) {
        n=capacity;
        hmap = new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)){
            return -1;
        }
        Node temp = hmap.get(key);
        remove(temp);
        insert(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(hmap.containsKey(key)){
            Node node1=hmap.get(key);
            remove(node1);
        }
        if(hmap.size()==n){
            remove(tail.prev);
        }
        insert(node);
        
    }
    public void insert(Node node){
        hmap.put(node.key, node);
        Node temp=head.next;
        head.next=node;
        node.next=temp;
        node.prev=head;
        temp.prev=node;
        return;
    }
    public void remove(Node node){
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