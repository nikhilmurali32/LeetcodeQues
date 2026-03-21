class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // return helper(m-1, n-1, dp);


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    // public int helper(int i, int j, int[][] dp){
    //     if(i==0 || j==0){
    //         return dp[i][j]=1;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     return dp[i][j] = helper(i-1, j, dp)+helper(i, j-1, dp);
    // }
}