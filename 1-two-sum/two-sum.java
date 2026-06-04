class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            if(indices.containsKey(target-nums[i])){
                res[0] = indices.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            indices.put(nums[i], i);
        }
        return res;
    }
}