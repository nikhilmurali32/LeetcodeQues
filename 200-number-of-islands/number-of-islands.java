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
            int[] currIJ = landCells.remove();
            int currI = currIJ[0];
            int currJ = currIJ[1];
            for(int k=0; k<dirs.length; k++){
                int newI = currI+dirs[k][0], newJ = currJ+dirs[k][1];
                if(newI>= 0 && newI<m && newJ >= 0 && newJ<n && grid[newI][newJ]=='1'){
                    grid[newI][newJ]='0';
                    landCells.add(new int[]{newI, newJ});                    
                }
            }
            
        }
    }
}