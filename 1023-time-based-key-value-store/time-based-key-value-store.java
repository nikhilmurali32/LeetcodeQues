class TimeMap {
    class Node{
        String value;
        int timestamp;
        Node next=null;
        Node(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    HashMap<String, List<Node>> hmap;
    public TimeMap() {
        hmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value, timestamp);
        if(!hmap.containsKey(key)){
            hmap.put(key, new ArrayList<>());
            hmap.get(key).add(node);
            return;
        }
        List<Node> list = hmap.get(key);
        list.get(list.size()-1).next = node;
        list.add(node);
        return;
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = hmap.get(key);
        if(list==null || list.size()==0){
            return "";
        }
        int i=list.size()-1;
        if(list.get(i).timestamp<=timestamp){
            return list.get(i).value;
        }
        while(i>=0 && list.get(i).timestamp>timestamp){
            i--;
        }
        if(i<0){
            return "";
        }
        return list.get(i).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */