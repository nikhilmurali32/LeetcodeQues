class Solution {
    int[][] res;
    char ch=' ';
    int val;
    int len;
    public int[][] generateMatrix(int n) {
        len=n;
        res = new int[n][n];
        val=1;
        for(int i=0; i<n; i++){
            ch='r';
            dfs(i, i, n-i);
            ch=' ';
        }
        return res;
    }
    public void dfs( int i, int j, int n){
        if(i<len-n || i>n-1 || j<len-n || j>n-1 || res[i][j] != 0){
            if(j>n-1){
                ch='d';
            }
            else if(i>n-1){
                ch='l';
            }
            else if(j<len-n){
                ch='u';
            }
            else{
                ch=' ';
            }
            return;
        }
        res[i][j]=val;
        val++;
        if(ch=='r'){
            dfs(i, j+1, n);
        }
        if(ch=='d'){
            dfs(i+1, j, n);
        }
        if(ch=='l'){
            dfs(i, j-1, n);
        }
        if(ch=='u'){
            dfs(i-1, j, n);
        }
    }
}