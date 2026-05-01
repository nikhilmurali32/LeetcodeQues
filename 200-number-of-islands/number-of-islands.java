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
        grid[i][j]='0';
        Queue<int[]> landCells = new LinkedList<>();
        landCells.add(new int[]{i,j});
        while(!landCells.isEmpty()){
            int size=landCells.size();
            int currI = landCells.peek()[0];
            int currJ = landCells.remove()[1];
            for(int k=-1; k<=1; k++){
                if(k==0){
                    continue;
                }
                if(currI+k >= 0 && currI+k<m && grid[currI+k][currJ]=='1'){
                    grid[currI+k][currJ]='0';
                    landCells.add(new int[]{currI+k, currJ});
                }
                if(currJ+k >= 0 && currJ+k<n && grid[currI][currJ+k]=='1'){
                    grid[currI][currJ+k]='0';
                    landCells.add(new int[]{currI, currJ+k});
                }
            }
            
        }
    }
}