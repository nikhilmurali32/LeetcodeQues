class MyHashMap {
    List<int[]> list;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] == key){
                list.get(i)[1] = value;
                return;
            }
        }
        list.add(new int[]{key, value});
    }
    
    public int get(int key) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] == key){
                return list.get(i)[1];
            }
        }
        return -1;        
    }
    
    public void remove(int key) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] == key){
                list.remove(i);
                return;
            }
        }
        return;        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */