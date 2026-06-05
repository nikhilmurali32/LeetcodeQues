class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Character>> hmap = new HashMap<>();
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                String rowKey = "R"+String.valueOf(i);
                String colKey = "C"+String.valueOf(j);
                String boxKey = String.valueOf(i/3)+"B"+String.valueOf(j/3);
                if(!hmap.containsKey(rowKey)){
                    hmap.put(rowKey, new HashSet<>());
                }
                if(!hmap.get(rowKey).add(board[i][j])){
                    return false;
                }
                if(!hmap.containsKey(colKey)){
                    hmap.put(colKey, new HashSet<>());
                }
                if(!hmap.get(colKey).add(board[i][j])){
                    return false;
                }
                if(!hmap.containsKey(boxKey)){
                    hmap.put(boxKey, new HashSet<>());
                }
                if(!hmap.get(boxKey).add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}