class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] minDistance = new int[m][n];
        for(int[] row:minDistance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDistance[0][0]=0;
        int[][] directions = new int[][]{{1,0}, {0,1}, {0, -1}, {-1,0}};
        PriorityQueue<int[]> leastEffort = new PriorityQueue<>((a,b)->a[2]-b[2]);
        leastEffort.add(new int[]{0, 0, 0});
        int res = 0;
        int max=0;
        while(!leastEffort.isEmpty()){
            int[] currCell = leastEffort.remove();
            int currDist = currCell[2];
            int i=currCell[0], j=currCell[1];
            max=Math.max(max, currDist);
            if(i==m-1 && j==n-1){
                res=max;
                break;
            }
            for(int[] dir:directions){
                int x=i+dir[0], y=j+dir[1];
                if(x>=0 && x<m && y>=0 && y<n && Math.abs(heights[i][j]-heights[x][y])<minDistance[x][y]){
                    minDistance[x][y] = Math.abs(heights[i][j]-heights[x][y]);
                    leastEffort.add(new int[]{x, y, Math.abs(heights[i][j]-heights[x][y])});
                }
            }
        }
        return res;
    }
}