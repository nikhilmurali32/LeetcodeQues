class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int h:hand){
            tmap.put(h, tmap.getOrDefault(h,0)+1);
        }
        while(!tmap.isEmpty()){
            int first = tmap.firstKey();
            for(int i=first; i<first+groupSize; i++){
                if(!tmap.containsKey(i)){
                    return false;
                }
                int count=tmap.get(i);
                if(count==1){
                    tmap.remove(i);
                }
                else{
                    tmap.put(i, count-1);
                }
            }
        }
        return true;
    }
}