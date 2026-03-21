class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(triangle, 0, 0, n, dp);
    }
    public int helper(List<List<Integer>> triangle, int row, int ind, int n, Integer[][] dp){
        if(row==n-1){
            return dp[row][ind]=triangle.get(row).get(ind);
        }
        if(dp[row][ind] != null){
            return dp[row][ind];
        }
        return dp[row][ind]=Math.min(triangle.get(row).get(ind) + helper(triangle, row+1, ind, n, dp), triangle.get(row).get(ind) + helper(triangle, row+1, ind+1, n, dp));
    }
}