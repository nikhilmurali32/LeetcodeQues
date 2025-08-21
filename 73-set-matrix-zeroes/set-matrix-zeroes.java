class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    for(int x=0; x<m; x++){
                        if(matrix[x][j]!=0){
                            matrix[x][j]=12345;
                        }
                    }
                    for(int y=0; y<n; y++){
                        if(matrix[i][y]!=0){
                            matrix[i][y]=12345;
                        }
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==12345){
                    matrix[i][j]=0;
                }
            }
        }
    }
}