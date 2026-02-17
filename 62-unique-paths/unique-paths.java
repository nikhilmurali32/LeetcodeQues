class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(m, n, 0, 0);
    }
    public int helper(int m, int n, int i, int j){
        if(i<0 || i>m-1 || j<0 || j>n-1){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        return dp[i][j]=helper(m, n, i+1, j)+helper(m, n, i, j+1);
    }
}