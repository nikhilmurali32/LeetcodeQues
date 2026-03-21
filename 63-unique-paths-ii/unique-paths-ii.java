class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] top=new int[n];
        int left=0, tot=0;
        for(int i=0; i<n; i++){
            if(obstacleGrid[0][i]==0){
                top[i]=1;
                tot=1;
            }
            else{
                tot=0;
                break;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    tot=0;
                    left=0;
                    top[j]=0;
                }
                else{
                    tot = top[j]+left;
                    top[j]=tot;
                    left=tot;
                }
            }
            left=0;
        }
        return tot;        
    }
}