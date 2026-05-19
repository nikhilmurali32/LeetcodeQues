class BrowserHistory {
    class urlNode{
        String name;
        urlNode next;
        urlNode prev;
        urlNode(String name){
            this.name = name;
            next=null;
            prev=null;
        }
    }
    LinkedList<urlNode> history = new LinkedList<>();
    urlNode curr;
    public BrowserHistory(String homepage) {
        urlNode home = new urlNode(homepage);
        history.add(home);
        curr = home;
    }
    
    public void visit(String url) {
        urlNode link = new urlNode(url);
        curr.next = link;
        link.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps>0 && curr.prev!=null){
            curr = curr.prev;
            steps--;
        }
        return curr.name; 
    }
    
    public String forward(int steps) {
        while(steps>0 && curr.next!=null){
            curr = curr.next;
            steps--;
        }
        return curr.name;        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */