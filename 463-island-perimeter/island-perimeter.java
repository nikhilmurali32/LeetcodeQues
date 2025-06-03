class Solution {
    int m;
    int n;
    int count;
    public int islandPerimeter(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    dfs(grid, i, j);
                    return count;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>m-1 || j<0 || j>n-1 || grid[i][j]==0){
            count++;
            return;
        }
        if(grid[i][j]==-1){
            return;
        }
        grid[i][j]=-1;
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
    }
}