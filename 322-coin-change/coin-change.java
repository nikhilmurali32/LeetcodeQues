class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];

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
    }
}