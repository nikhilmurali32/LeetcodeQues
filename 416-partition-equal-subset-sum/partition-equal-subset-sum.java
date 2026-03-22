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
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for(int i=0; i<n; i++){
            for(int j=target; j>=1; j--){
                if(j>=nums[i]){
                    dp[j] = dp[j-nums[i]] || dp[j];
                }
                else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }
}