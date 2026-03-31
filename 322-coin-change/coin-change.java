class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int ans=helper(coins, amount, coins.length-1, dp);
        return ans==100000?-1:ans;
    }
    public int helper(int[] coins, int amount, int ind, int[][] dp){
        if(amount==0){
            return dp[ind][amount]=0;
        }
        if(ind<0){
            return 100000;
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int doNotTake = helper(coins, amount, ind-1, dp);
        int take=100000;
        if(coins[ind]<=amount){
            take = 1+helper(coins, amount-coins[ind], ind, dp);
        }
        return dp[ind][amount]=Math.min(take, doNotTake);
    }
}