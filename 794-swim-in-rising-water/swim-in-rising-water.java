class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        PriorityQueue<int[]> minHeight = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        minHeight.add(new int[]{0,0,grid[0][0]});
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] minCellHeight = new int[m][n];
        for(int[] row:minCellHeight){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int res=0;
        while(!minHeight.isEmpty()){
            int[] currCell = minHeight.remove();
            int i = currCell[0], j = currCell[1];
            int currMax = currCell[2];
            if(i==m-1 && j==n-1){
                res=currMax;
                break;
            }
            for(int[] dir:dirs){
                int x=i+dir[0], y=j+dir[1];
                if(x>=0 && x<m && y>=0 && y<n){
                    int tempcurrMax = Math.max(currMax, grid[x][y]);
                    if(tempcurrMax < minCellHeight[x][y]){
                        minCellHeight[x][y] = tempcurrMax;
                        minHeight.add(new int[]{x,y,tempcurrMax});
                    }
                }
            }
        }
        return res;
    }
}