class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0; i<capacity.length; i++){
            if(hmap.get(capacity[i])==null){
                hmap.put(capacity[i], i);
            }
            if(capacity[i]>=itemSize){
                min=Math.min(min, capacity[i]);
            }
        }
        if(hmap.get(min)!=null){
            return hmap.get(min);
        }
        return -1;
    }
}