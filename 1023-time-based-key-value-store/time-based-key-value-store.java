class TimeMap {
    HashMap<String, String> hmap;
    HashMap<String, List<Integer>> pos;
    public TimeMap() {
        hmap = new HashMap<>();
        pos = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> list;
        if(pos.containsKey(key)){
            list = pos.get(key);
        }
        else{
            list = new ArrayList<>();
        }
        list.add(timestamp);
        pos.put(key, list);
        String newKey = key+","+String.valueOf(timestamp);
        hmap.put(newKey, value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> posArr;
        if(pos.containsKey(key)){
            posArr = pos.get(key);
        }
        else{
            return "";
        }
        if(posArr.size()==0){
            return "";
        }
        int l=0, r=posArr.size()-1;
        int res=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(timestamp >= posArr.get(mid)){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(res<=-1 || timestamp<posArr.get(res)){
            return "";
        }
        String findKey = key + "," + String.valueOf(posArr.get(res));
        if(hmap.containsKey(findKey)){
            return hmap.get(findKey);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */