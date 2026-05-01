class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }
    public void bfs(char[][] grid, int i, int j){
        int m=grid.length, n=grid[0].length;
        int[][] dirs = {{0,1}, {0, -1}, {-1, 0}, {1,0}};
        grid[i][j]='0';
        Queue<int[]> landCells = new LinkedList<>();
        landCells.add(new int[]{i,j});
        while(!landCells.isEmpty()){
            int size=landCells.size();
            int currI = landCells.peek()[0];
            int currJ = landCells.remove()[1];
            for(int[] dir:dirs){
                int newI = currI+dir[0], newJ = currJ+dir[1];
                if(newI>= 0 && newI<m && grid[newI][currJ]=='1'){
                    grid[newI][currJ]='0';
                    landCells.add(new int[]{newI, currJ});
                }
                if(newJ >= 0 && newJ<n && grid[currI][newJ]=='1'){
                    grid[currI][newJ]='0';
                    landCells.add(new int[]{currI, newJ});
                }
            }
            
        }
    }
}