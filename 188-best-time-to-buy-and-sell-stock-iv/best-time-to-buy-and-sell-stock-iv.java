class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp = new int[k+1][n+1];
        dp[0][0]=0;
        for(int i=1; i<k+1; i++){
            for(int j=1; j<n+1; j++){
                int max=Integer.MIN_VALUE;;
                for(int l=1; l<=j; l++){
                    max=Math.max(max, prices[j-1]-prices[l-1]+dp[i-1][l]);
                }
                dp[i][j]=Math.max(dp[i][j-1], max);
            }
        }
        return dp[k][n];
    }
}