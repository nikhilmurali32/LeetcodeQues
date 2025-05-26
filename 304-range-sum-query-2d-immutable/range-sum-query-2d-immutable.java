class NumMatrix {
    int[][] matrix;
    int[][] orig_matrix;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        orig_matrix = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                orig_matrix[i][j]=matrix[i][j];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    if(j==0){
                        matrix[i][j]=matrix[i][j];
                    }
                    else{
                        matrix[i][j] += matrix[i][j-1];
                    }
                }
                else if(j==0){
                    matrix[i][j] += matrix[i-1][j];
                }
                else{
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
                }
                System.out.println(matrix[i][j]);
            }
            System.out.println("---");
        }
        this.matrix=matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.println(matrix[row2][col2]);
        if(row1==0 || col1==0){
            if(row1==0 && col1==0){
                return matrix[row2][col2];
            }
            else if(row1==0){
                return matrix[row2][col2]-matrix[row2][col1-1];
            }
            else{
                return matrix[row2][col2]-matrix[row1-1][col2];
            }
        }
        return matrix[row2][col2]-matrix[row1-1][col2]-matrix[row2][col1-1]+matrix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */