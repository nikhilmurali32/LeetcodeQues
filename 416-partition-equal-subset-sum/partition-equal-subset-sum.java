class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        }
        Arrays.sort(nums);
        int target = sum/2;
        dp = new Boolean[nums.length+1][target+1];
        dp[0][0]=true;
        return helper(nums, 0, target);
    }
    public boolean helper(int[] nums, int ind, int target){
        if(target<0){
            return false;
        }
        if(target==0){
            return dp[ind][target] = true;
        }
        if(dp[ind][target] != null){
            return dp[ind][target];
        }
        for(int i=ind; i<nums.length; i++){
            if(nums[i]<=target){
                return dp[ind][target] = (helper(nums, ind+1, target) || helper(nums, i+1, target-nums[i]));
            }
        }
        return dp[ind][target] = false;
    }
}