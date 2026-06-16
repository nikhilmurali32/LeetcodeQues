class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int h:hand){
            freq.put(h, freq.getOrDefault(h,0)+1);
        }
        while(!freq.isEmpty()){
            int first=freq.firstKey();
            for(int i=first; i<first+groupSize; i++){
                if(!freq.containsKey(i)){
                    return false;
                }
                freq.put(i, freq.get(i)-1);
                if(freq.get(i)==0){
                    freq.remove(i);
                }
            }
        }
        return true;
    }
}