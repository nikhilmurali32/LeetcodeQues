class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        // int min=Integer.MAX_VALUE;
        Integer[][] dp = new Integer[n][n];
        // for(int i=0; i<n; i++){
        //     min = Math.min(min, helper(matrix, 0, i, n, dp));
        // }
        // return min;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    if(j==0){
                        dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j+1]);
                    }
                    else if(j==n-1){
                        dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j-1]);
                    }
                    else{
                        dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j+1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
    // public int helper(int[][] matrix, int row, int ind, int n, Integer[][] dp){
    //     if(row==n-1){
    //         return dp[row][ind]=matrix[row][ind];
    //     }
    //     if(dp[row][ind] != null){
    //         return dp[row][ind];
    //     }
    //     if(ind==0){
    //         return dp[row][ind]=Math.min(matrix[row][ind]+helper(matrix, row+1, ind, n, dp), matrix[row][ind]+helper(matrix, row+1, ind+1, n, dp));
    //     }
    //     else if(ind==n-1){
    //         return dp[row][ind]=Math.min(matrix[row][ind]+helper(matrix, row+1, ind, n, dp), matrix[row][ind]+helper(matrix, row+1, ind-1, n, dp));
    //     }
    //     return dp[row][ind]=Math.min(matrix[row][ind]+helper(matrix, row+1, ind-1, n, dp), Math.min(matrix[row][ind]+helper(matrix, row+1, ind, n, dp), matrix[row][ind]+helper(matrix, row+1, ind+1, n, dp)));
    // }
}