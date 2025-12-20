class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums){
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer, Integer> entry:hmap.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int[] res=new int[k];
        int j=0;
        while(!pq.isEmpty() && j<k){
            res[j]=pq.remove().getKey();
            j++;
        }
        return res;
    }
}