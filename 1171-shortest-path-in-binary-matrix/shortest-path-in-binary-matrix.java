class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0,0)));
        int[] row = new int[]{-1,0,1};
        int[] col = new int[]{-1,0,1};
        boolean[][] vis = new boolean[m][n];
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                List<Integer> list = q.poll();
                int r=list.get(0);
                int c=list.get(1);
                if(r==m-1 && c==n-1){
                    return steps;
                }
                for(int ro:row){
                    for(int co:col){
                        if(ro==0 && co==0){
                            continue;
                        }
                        int rowInd=r+ro;
                        int colInd=c+co;
                        if(rowInd<0 || colInd<0 || rowInd>m-1 || colInd>n-1 || vis[rowInd][colInd]){
                            continue;
                        }
                        if(grid[rowInd][colInd]==0){
                            List<Integer> tempList = new ArrayList<>();
                            tempList.add(rowInd);
                            tempList.add(colInd);
                            q.add(tempList);
                            vis[rowInd][colInd]=true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}