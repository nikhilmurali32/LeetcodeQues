class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count=0, count_one=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    int[] arr = {i, j};
                    q.add(arr);
                    count++;
                }
                else if(grid[i][j]==1){
                    count_one++;
                }
            }
        }
        if(count==0 && count_one>0){
            return -1;
        }
        if(count==0 && count_one==0){
            return 0;
        }
        int min=-1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] arr = q.poll();
                int[] x = {0,1,-1,0};
                int[] y = {1, 0, 0, -1};
                for(int k=0; k<4; k++){
                    if(arr[0]+x[k] >= 0 && arr[0]+x[k] < m && arr[1]+y[k]>=0 && arr[1]+y[k] < n && grid[arr[0]+x[k]][arr[1]+y[k]]==1){
                        int[] nei = {arr[0]+x[k], arr[1]+y[k]};
                        q.offer(nei);
                        grid[arr[0]+x[k]][arr[1]+y[k]]=2;
                    }
                }
            }
            min++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return min;
    }
}