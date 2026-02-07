class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target, nums.length);

    }
    public int helper(int[] nums, int sum, int ind, int target, int n){
        if(ind==n){
            if(sum==target){
                return 1;
            }
            else{
                return 0;
            }
        }
        int add = helper(nums, sum+nums[ind], ind+1, target, n);
        int sub = helper(nums, sum-nums[ind], ind+1, target, n);
        int ways = add+sub;
        return ways;
    }
}