class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int res = helper(coins, amount, 0, dp);
        return res==100000?-1:res;
    }
    public int helper(int[] coins, int amount, int ind, int[][] dp){
        if(amount==0){
            return dp[ind][amount]=0;
        }
        if(ind>=coins.length){
            return dp[ind][amount]=100000;
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int take=100000;
        int doNotTake = helper(coins, amount, ind+1, dp);
        if(amount>=coins[ind]){
            take = 1+helper(coins, amount-coins[ind], ind, dp);
        }
        return dp[ind][amount]=Math.min(doNotTake,take);
    }
}