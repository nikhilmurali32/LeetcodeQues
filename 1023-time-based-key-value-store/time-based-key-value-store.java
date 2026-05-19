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
        // list.get(list.size()-1).next = node;
        list.add(node);
        return;
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = hmap.get(key);
        if(list==null || list.size()==0){
            return "";
        }
        if(list.get(list.size()-1).timestamp<=timestamp){
            return list.get(list.size()-1).value;
        }
        if(list.get(0).timestamp>timestamp){
            return "";
        }
        int l=0, r=list.size()-1;
        while(l<r){
            int mid = (int)Math.ceil((double)(l+r)/2);
            if(list.get(mid).timestamp>timestamp){
                r=mid-1;
            }
            else{
                l=mid;
            }
        }
        return list.get(l).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */