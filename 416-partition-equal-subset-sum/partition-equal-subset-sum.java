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
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][0]=true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=target; j++){
                if(j==0){
                    dp[i][j]=true;
                }
                else{
                    boolean doNotTake = dp[i-1][j];
                    boolean take=false;
                    if(j>=nums[i-1]){
                        take = dp[i-1][j-nums[i-1]];
                    }
                    dp[i][j] = doNotTake || take;
                }
            }
        }
        return dp[n][target];
    }
}