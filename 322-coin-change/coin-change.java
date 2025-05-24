class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans=helper(coins, amount, 0, new int[coins.length+1][amount+1]);
        if(ans==Integer.MAX_VALUE-1){
            return -1;
        }
        return ans;
    }
    public int helper(int[] coins, int amount, int start, int[][] dp){
        if(dp[start][amount] != 0){
            return dp[start][amount];
        }
        if(amount<=0){
            return dp[start][amount] = 0;
        }
        // else if(amount==0){
        //     return 1;
        // }
        for(int i=start; i<coins.length; i++){
            if(coins[i]<=amount){
                return dp[i][amount] = Math.min(helper(coins, amount, i+1, dp), 1+helper(coins, amount-coins[i], i, dp));
            }
        }
        return Integer.MAX_VALUE-1; 
    }
}