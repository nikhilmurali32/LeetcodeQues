class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int citation: citations){
            int x=citation;
            if(citation>n){
                x=n;
            }
            hmap.put(x, hmap.getOrDefault(x,0)+1);
        }
        List<Integer> freq = new ArrayList<>();
        for(int i=0; i<=n; i++){
            freq.add(0);
        }
        for(Map.Entry<Integer, Integer> entry:hmap.entrySet()){
            freq.set(entry.getKey(), entry.getValue());
        }
        int countSoFar=0;
        for(int i=n; i>=0; i--){
            countSoFar += freq.get(i);
            if(countSoFar>=i){
                return i;
            }
        }
        return -1;
    }
}