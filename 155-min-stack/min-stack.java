class MinStack {
    Node head=null;
    public MinStack() {
        // head = new Node(0,0,null);
    }
    
    public void push(int val) {
        if(head==null){
            head = new Node(val, val, null);
        }
        else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    public class Node{
        Node next;
        int val;
        int min;
        Node(int val, int min, Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */