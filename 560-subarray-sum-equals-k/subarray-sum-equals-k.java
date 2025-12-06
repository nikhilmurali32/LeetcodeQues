class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==1 && k!=nums[0]){
            return 0;
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int res=0, sum=0;
        hmap.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(hmap.containsKey(sum-k)){
                res += hmap.get(sum-k);
            }
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}