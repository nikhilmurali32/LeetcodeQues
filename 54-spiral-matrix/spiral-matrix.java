class Solution {
    List<Integer> list;
    boolean[][] dp;
    char ch='r';
    boolean turns=false;
    public List<Integer> spiralOrder(int[][] matrix) {
        list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        dp = new boolean[m][n];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i==j){
                    ch='r';
                    dfs(matrix, i, j, 'r', m-i, n-j);
                    ch=' ';
                }
            }
        }
        return list;
    }
    public void dfs(int[][] matrix, int i, int j, char dir, int m, int n){
        if(i<matrix.length-m || i>m-1 || j<matrix[0].length-n || j>n-1 || dp[i][j]){
            if(j>n-1){
                ch='d';
            }
            else if(i>m-1){
                ch='l';
            }
            else if(j<matrix[0].length-n){
                ch='u';
            }
            else{
                ch=' ';
            }
            return;
        }
        dp[i][j]=true;
        list.add(matrix[i][j]);
        if(ch=='r'){
            dfs(matrix, i, j+1, 'r', m, n);
        }
        if(ch=='d'){
            dfs(matrix, i+1, j, 'd', m, n);
        }
        if(ch=='l'){
            dfs(matrix, i, j-1, 'l', m, n);
        }
        if(ch=='u'){
            dfs(matrix, i-1, j, 'u', m, n);
        }
    }
}