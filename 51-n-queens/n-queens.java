class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        HashSet<Integer> hset_x = new HashSet<>();
        HashSet<Integer> hset_y = new HashSet<>();
        HashSet<Integer> hset_diag1 = new HashSet<>();
        HashSet<Integer> hset_diag2 = new HashSet<>();
        boolean[][] dp = new boolean[n][n];
        backtrack(hset_x, hset_y, hset_diag1, hset_diag2, 0, n, dp);
        return list;
    }
    public void backtrack(HashSet<Integer> hset_x, HashSet<Integer> hset_y, HashSet<Integer> hset_diag1, HashSet<Integer> hset_diag2, int col, int n, boolean[][] dp){
        if(col==n){
            List<String> l = new ArrayList<>();
            for(int i=0; i<n; i++){
                String str="";
                for(int j=0; j<n; j++){
                    if(dp[i][j]){
                        str+="Q";
                    }
                    else{
                        str+=".";
                    }
                }
                l.add(str);
            }
            list.add(l);
            return;
        }
        hset_y.add(col);
        for(int k=0; k<n; k++){
            if(hset_x.contains(k) || hset_diag1.contains(k+col) || hset_diag2.contains(k-col)){
                continue;
            }
            hset_x.add(k);
            hset_diag1.add(k+col);
            hset_diag2.add(k-col);
            dp[k][col]=true;
            backtrack(hset_x, hset_y, hset_diag1,hset_diag2, col+1, n, dp);
            hset_x.remove(k);
            hset_diag1.remove(k+col);
            hset_diag2.remove(k-col);
            dp[k][col]=false;
        }
        hset_y.remove(col);
    }
    public boolean isValid(int i, int j, int n){
        return (i>=0 && i<n && j>=0 && j<n);
    }
}