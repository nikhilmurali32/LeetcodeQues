class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> hmap = new HashMap<>();
        return helper(nums, 0, 0, target, nums.length, hmap);

    }
    public int helper(int[] nums, int sum, int ind, int target, int n, HashMap<String, Integer> hmap){
        if(ind==n){
            if(sum==target){
                return 1;
            }
            else{
                return 0;
            }
        }
        String key = ind + "," + sum;
        if(hmap.containsKey(key)){
            return hmap.get(key);
        }
        int add = helper(nums, sum+nums[ind], ind+1, target, n, hmap);
        int sub = helper(nums, sum-nums[ind], ind+1, target, n, hmap);
        int ways = add+sub;
        hmap.put(key, ways);
        return ways;
    }
}