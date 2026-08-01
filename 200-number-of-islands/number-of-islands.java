class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    bfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j, m , n);
        dfs(grid, i, j-1, m , n);
        dfs(grid, i, j+1, m , n);
        dfs(grid, i-1, j, m , n);
    }
    public void bfs(char[][] grid, int i, int j, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            int[] cell = q.remove();
            for(int[] dir:dirs){
                int x=cell[0]+dir[0], y=cell[1]+dir[1];
                if(x<0 || x>=m || y<0 || y>=n){
                    continue;
                }
                if(grid[x][y]=='1'){
                    q.add(new int[]{x, y});
                    grid[x][y]='0';
                }
            }
        }
        return;
    }
}