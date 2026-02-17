class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        // dp[0][0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    // public int helper(int m, int n, int i, int j){
    //     if(i<0 || i>m-1 || j<0 || j>n-1){
    //         return 0;
    //     }
    //     if(i==m-1 && j==n-1){
    //         return 1;
    //     }
    //     if(dp[i][j] != 0){
    //         return dp[i][j];
    //     }
    //     return dp[i][j]=helper(m, n, i+1, j)+helper(m, n, i, j+1);
    // }
}