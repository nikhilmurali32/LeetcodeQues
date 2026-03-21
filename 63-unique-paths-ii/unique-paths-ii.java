class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        boolean seen=false;
        for(int i=0; i<n; i++){
            if(obstacleGrid[0][i]==0 && !seen){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
                seen=true;
            }
        }
        seen=false;
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0]==0 && !seen){
                dp[i][0]=1;
            }
            else{
                dp[i][0]=0;
                seen=true;
            }
        }
        return helper(obstacleGrid, m-1, n-1, dp);        
    }
    public int helper(int[][] arr, int i, int j, int[][] dp){
        if(i==0 || j==0){
            return dp[i][j];
        }
        if((i>0 && j>0) && arr[i][j]==1){
            return dp[i][j]=0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = helper(arr, i-1, j, dp) + helper(arr, i, j-1, dp);
    }
}