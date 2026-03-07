class Solution {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return helper(1, n);
    }
    public int helper(int l, int r){
        if(l>=r){
            return 0;
        }
        if(dp[l][r] !=0){
            return dp[l][r];
        }
        int min=Integer.MAX_VALUE;
        for(int i=l; i<=r; i++){
            min=Math.min(min, Math.max(helper(l, i-1), helper(i+1, r))+i);
        }
        return dp[l][r]=min;
    }
}