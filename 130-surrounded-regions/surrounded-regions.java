class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0, m, n);
            }
            if(board[i][n-1]=='O'){
                dfs(board, i, n-1, m, n);
            }
        }
        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i, m, n);
            }
            if(board[m-1][i]=='O'){
                dfs(board, m-1, i, m, n);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
                else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, int m, int n){
        if(i<0 || i>m-1 || j<0 || j>n-1 || board[i][j]=='X' || board[i][j]=='#'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i, j+1, m, n);
        dfs(board, i+1, j, m, n);
        dfs(board, i, j-1, m, n);
        dfs(board, i-1, j, m, n);
    }
}