class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=nums.length; i++){
            list.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
            list.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int ind=0;
        for(int i=list.size()-1; i>=0 && ind<k; i--){
            if(!list.get(i).isEmpty()){
                for(int ele:list.get(i)){
                    res[ind]=ele;
                    ind++;
                }
            }
        }
        return res;
    }
}