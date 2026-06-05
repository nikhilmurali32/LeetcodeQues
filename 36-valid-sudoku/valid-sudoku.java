class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hset = new HashSet<>();
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(!hset.add("R"+i+board[i][j]) || !hset.add("C"+j+board[i][j]) || !hset.add(i/3 + "B" + j/3+board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}