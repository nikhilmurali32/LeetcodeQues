class Solution {
    int m;
    int n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j]==1){
                    if(dfs(grid1, grid2, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i<0 || i>m-1 || j<0 || j>n-1 || grid2[i][j]==0){
            return true;
        }
        boolean isSubisland=true;
        if(grid2[i][j]==1 && grid1[i][j]==0){
            isSubisland = false;
        }
        grid2[i][j]=0;
        
        boolean down = dfs(grid1, grid2, i+1, j);
        boolean right = dfs(grid1, grid2, i, j+1); 
        boolean up = dfs(grid1, grid2, i-1, j);
        boolean left = dfs(grid1, grid2, i, j-1);
        return isSubisland && down && right && up && left;
    }
}