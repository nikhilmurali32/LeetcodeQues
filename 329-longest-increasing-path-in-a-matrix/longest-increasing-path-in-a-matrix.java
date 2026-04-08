class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int max=0;
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, dfs(matrix, i, j, m, n, -1, dp));
            }
        }
        return max;
    }
    public int dfs(int[][] matrix, int i, int j, int m, int n, int prev, int[][] dp){
        if(i<0 || i>m-1 || j<0 || j>n-1 || matrix[i][j]<=prev){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 1+dfs(matrix, i, j+1, m, n, matrix[i][j], dp);
        int down = 1+dfs(matrix, i+1, j, m, n,matrix[i][j], dp);
        int left = 1+dfs(matrix, i, j-1, m, n,matrix[i][j], dp);
        int up = 1+dfs(matrix, i-1, j, m, n,matrix[i][j], dp);
        return dp[i][j] = Math.max(right, Math.max(down, Math.max(left, up)));
    }
}