class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i], i);
            }
            if(hmap.containsKey(target-nums[i])){
                if(hmap.get(target-nums[i])==i){
                    continue;
                }
                res[0]=hmap.get(target-nums[i]);
                res[1]=i;
                break;
            }
        }
        return res;
    }
}