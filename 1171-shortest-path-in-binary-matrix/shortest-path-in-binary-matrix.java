class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> zeroIndices = new LinkedList<>();
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        zeroIndices.add(new int[]{0,0});
        int count=0;
        int[][] dir = {{-1, -1}, {-1,0}, {-1,1}, {0,1}, {0,-1}, {1,-1}, {1,0}, {1,1}};
        while(!zeroIndices.isEmpty()){
            int size = zeroIndices.size();
            for(int i=0; i<size; i++){
                int[] ind = zeroIndices.remove();
                int x=ind[0], y=ind[1];
                if(x==m-1 && y==n-1){
                    count++;
                    return count;
                }
                for(int[] d:dir){
                    if(x+d[0]>=0 && y+d[1]>=0 && x+d[0]<m && y+d[1]<n && grid[x+d[0]][y+d[1]]==0){
                        grid[x+d[0]][y+d[1]]=1;
                        zeroIndices.add(new int[]{x+d[0], y+d[1]});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}