class Solution {
    HashMap<String, Integer> hmap;
    public int findTargetSumWays(int[] nums, int target) {
        hmap = new HashMap<>();
        return helper(nums, target, 0, 0);
    }
    public int helper(int[] nums, int target, int sum, int ind){
        if(ind==nums.length){
            return sum==target?1:0;
        }
        String str = ind + "#" + sum;
        if(hmap.containsKey(str)){
            return hmap.get(str);
        }
        int total=0;
        total += helper(nums, target, sum+nums[ind], ind+1);
        total += helper(nums, target, sum-nums[ind], ind+1);
        hmap.put(str, total);
        return total;
    }
}