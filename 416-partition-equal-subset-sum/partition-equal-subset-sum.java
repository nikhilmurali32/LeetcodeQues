class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int target=0;
        for(int num:nums){
            target += num;
        }
        if(target%2 != 0){
            return false;
        }
        target=target/2;
        int[][] dp = new int[n][target+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return doesExist(nums, target, n-1, dp)==1?false:true;
    }
    public int doesExist(int[] nums, int target, int ind, int[][] dp){
        if(target==0){
            return dp[ind][target]=0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        if(ind==0){
            if(target==nums[ind]){
                dp[ind][target]=0;
            }
            else{
                dp[ind][target]=1;
            }
            return dp[ind][target];
        }
        int doNotTake = doesExist(nums, target, ind-1, dp);
        int take=1;
        if(target>=nums[ind]){
            take = doesExist(nums, target-nums[ind], ind-1, dp);
        }
        if(doNotTake==0 || take==0){
            return dp[ind][target]=0;
        }
        return dp[ind][target]=1;
    }
}