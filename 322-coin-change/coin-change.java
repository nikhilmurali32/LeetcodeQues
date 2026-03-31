class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // Arrays.sort(coins);
        for(int i=0; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(i==0){
                    dp[i][j] = 100000;
                    continue;
                }
                int doNotTake = dp[i-1][j];
                int take = 100000;
                if(coins[i-1]<=j){
                    take = 1 + dp[i][j-coins[i-1]];
                }
                dp[i][j] = Math.min(doNotTake, take);
            }
        }
        return dp[n][amount]==100000?-1:dp[n][amount];
        // int ans=helper(coins, amount, coins.length-1, dp);
        // return ans==100000?-1:ans;
    }
    // public int helper(int[] coins, int amount, int ind, int[][] dp){
    //     if(amount==0){
    //         return dp[ind][amount]=0;
    //     }
    //     if(ind<0){
    //         return 100000;
    //     }
    //     if(dp[ind][amount] != -1){
    //         return dp[ind][amount];
    //     }
    //     int doNotTake = helper(coins, amount, ind-1, dp);
    //     int take=100000;
    //     if(coins[ind]<=amount){
    //         take = 1+helper(coins, amount-coins[ind], ind, dp);
    //     }
    //     return dp[ind][amount]=Math.min(take, doNotTake);
    // }
}