class TimeMap {
    class Node{
        String key, value;
        int timestamp;
        Node(String key, String value, int timestamp){
            this.key=key;
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    HashMap<String, List<Node>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k-> new ArrayList<>()).add(new Node(key, value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }
        List<Node> list = store.get(key);
        if(list==null || list.size()==0){
            return "";
        }
        if(list.get(0).timestamp>timestamp){
            return "";
        }
        if(list.get(list.size()-1).timestamp<timestamp){
            return list.get(list.size()-1).value;
        }
        int l=0, r=list.size()-1;
        while(l<r){
            int mid = (l+r+1)/2;
            if(list.get(mid).timestamp > timestamp){
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