class Solution {
    public int countPaths(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int max=0;
        int[][] dp = new int[m][n];
        for(int[] arr1:dp){
            Arrays.fill(arr1, -1);
        }
        int MOD = 1000000000+7;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = (max+dfs(grid, i, j, m, n, -1, dp, MOD))%MOD;
            }
        }
        return max%MOD;        
    }
    public int dfs(int[][] matrix, int i, int j, int m, int n, int prev, int[][] dp, int MOD){
        if(i<0 || i>m-1 || j<0 || j>n-1 || matrix[i][j]<=prev){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = dfs(matrix, i, j+1, m, n, matrix[i][j], dp, MOD)%MOD;
        int down = dfs(matrix, i+1, j, m, n,matrix[i][j], dp, MOD)%MOD;
        int left = dfs(matrix, i, j-1, m, n,matrix[i][j], dp, MOD)%MOD;
        int up = dfs(matrix, i-1, j, m, n,matrix[i][j], dp, MOD)%MOD;
        return dp[i][j] = (1 + right+down+left+up)%MOD;
    }
}