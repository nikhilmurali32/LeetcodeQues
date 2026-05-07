class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        List<List<Integer>> freqBucket = new ArrayList<>();
        for(int i=0; i<=n; i++){
            freqBucket.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry:freqMap.entrySet()){
            freqBucket.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int ind=0;
        for(int i=freqBucket.size()-1; i>=0 && ind<k; i--){
            for(int elem:freqBucket.get(i)){
                res[ind]=elem;
                ind++;
            }
        }
        return res;
    }
}