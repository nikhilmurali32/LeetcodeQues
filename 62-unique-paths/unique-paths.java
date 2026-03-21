class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // return helper(m-1, n-1, dp);

        int left=1, tot=1;
        int[] top = new int[n];
        Arrays.fill(top, 1);
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                tot = left + top[j];
                left=tot;
                top[j]=tot;
            }
            left=1;
        }
        return tot;
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