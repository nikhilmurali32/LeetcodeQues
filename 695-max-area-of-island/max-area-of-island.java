class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>m-1 || j<0 || j>n-1 || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        return 1+dfs(grid, i+1, j, m, n) + dfs(grid, i-1, j, m, n) + dfs(grid, i, j-1, m, n) + dfs(grid, i, j+1, m, n);
    }
}