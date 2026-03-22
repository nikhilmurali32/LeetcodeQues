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
        // int[][] dp = new int[n+1][target+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // return doesExist(nums, target, n-1, dp)==1?false:true;
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