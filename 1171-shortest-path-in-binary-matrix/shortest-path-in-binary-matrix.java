class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> zeroIndices = new LinkedList<>();
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        zeroIndices.add(new int[]{0,0});
        int count=0;
        boolean[][] visited = new boolean[m][n];
        visited[0][0]=true;
        while(!zeroIndices.isEmpty()){
            int size = zeroIndices.size();
            for(int i=0; i<size; i++){
                int[] ind = zeroIndices.remove();
                int x=ind[0], y=ind[1];
                if(x==m-1 && y==n-1){
                    count++;
                    return count;
                }
                for(int k=-1; k<=1; k++){
                    for(int j=-1; j<=1; j++){
                        if((k==0 && j==0) || x+k<0 || y+j<0 || x+k>=m || y+j>=n || grid[x+k][y+j]==1 || visited[x+k][y+j]){
                            continue;
                        }
                        visited[x+k][y+j]=true;
                        zeroIndices.add(new int[]{x+k, y+j});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}