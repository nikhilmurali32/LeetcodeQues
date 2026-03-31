class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int j=1; j<=amount; j++){
            dp[j] = 100000;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]<=j){
                    dp[j] = Math.min(dp[j], 1 + dp[j-coins[i-1]]);
                }
                else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[amount]==100000?-1:dp[amount];
    }
}