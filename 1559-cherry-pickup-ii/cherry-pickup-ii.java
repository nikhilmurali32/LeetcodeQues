class Solution {
    int rows;
    int cols;
    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return navigate(grid, 0, 0, cols-1, dp);
    }
    public int navigate(int[][] grid, int i, int j1, int j2, Integer[][][] dp){
        if(j1<0 || j2<0 || j1>=cols || j2>=cols || i>rows-1){
            return 0;
        }
        if(dp[i][j1][j2] != null){
            return dp[i][j1][j2];
        }
        int max=0;
        for(int j=-1; j<=1; j++){
            for(int k=-1; k<=1; k++){
                if(j1==j2){
                    max = Math.max(max, grid[i][j1] + navigate(grid, i+1, j1+j, j2+k, dp));
                }
                else{
                    max = Math.max(max, grid[i][j1] + grid[i][j2] + navigate(grid, i+1, j1+j, j2+k, dp));
                }
            }
        }
        return dp[i][j1][j2]=max;
    }
}