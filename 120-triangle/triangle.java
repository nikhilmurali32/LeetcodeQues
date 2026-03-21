class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp = new int[n][n];
        // return helper(triangle, 0, 0, n, dp);

        dp[0][0]=triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j==0){
                    dp[i][j] = triangle.get(i).get(0)+dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = triangle.get(i).get(j)+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(triangle.get(i).get(j)+dp[i-1][j], triangle.get(i).get(j)+dp[i-1][j-1]);
                }
                System.out.println(dp[i][j]);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min=Math.min(min, dp[n-1][i]);
        }
        return min;
    }
    // public int helper(List<List<Integer>> triangle, int row, int ind, int n, Integer[][] dp){
    //     if(row==n-1){
    //         return dp[row][ind]=triangle.get(row).get(ind);
    //     }
    //     if(dp[row][ind] != null){
    //         return dp[row][ind];
    //     }
    //     return dp[row][ind]=Math.min(triangle.get(row).get(ind) + helper(triangle, row+1, ind, n, dp), triangle.get(row).get(ind) + helper(triangle, row+1, ind+1, n, dp));
    // }
}