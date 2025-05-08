class Solution {
    int n;
    int m;
    boolean ans=false;
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] seen = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!seen[i][j] && dfs(grid, seen, i, j, grid[i][j])){
                        return true;
                    }
                }
            }
        return false;
    }
    public boolean dfs(char[][] grid, boolean[][] seen, int i, int j, char c){
        if(i<0 || i>n-1 || j<0 || j>m-1 || grid[i][j]!=c){
            return false;
        }
        if(seen[i][j]){
            return true;
        }
        seen[i][j]=true;
        grid[i][j]='#';
        boolean found=dfs(grid, seen, i+1, j, c) || dfs(grid, seen, i-1, j, c) || dfs(grid, seen, i, j-1, c) || dfs(grid, seen, i, j+1, c);
        grid[i][j]=c;
        return found;
    }
}