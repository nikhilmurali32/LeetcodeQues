class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<capacity.length; i++){
            if(hmap.get(capacity[i])==null){
                hmap.put(capacity[i], i);
            }
        }
        Arrays.sort(capacity);
        for(int i=0; i<capacity.length; i++){
            if(capacity[i]>=itemSize){
                return hmap.get(capacity[i]);
            }
        }
        return -1;
    }
}