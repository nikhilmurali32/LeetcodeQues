class MinStack {
    //declare minElem=MAX_VALUE
    Deque<Integer> normalStack;
    Deque<Integer> minStack; 
    public MinStack() {
        //initisalize stack object
        //initisalize stack object
        normalStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        // stack.add(val)
        // update minElem

        normalStack.addLast(val);
        if(minStack.isEmpty() || val<=minStack.peekLast()){
            minStack.addLast(val);
        }
    }
    
    public void pop() {
        // stack.remove()
        int removeElement = normalStack.removeLast();
        if(removeElement == minStack.peekLast()){
            minStack.removeLast();
        }

    }
    
    public int top() {
        // stack.peekfirst()
        return normalStack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
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