class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length+1][m+1][n+1];
        for(int i=0; i<strs.length+1; i++){
            for(int j=0; j<m+1; j++){
                for(int k=0; k<n+1; k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int[][] arr = new int[strs.length][2];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j)=='0'){
                    arr[i][0] += 1;
                }
                else{
                    arr[i][1] += 1;
                }
            }
        }
        return helper(arr, m, n, 0);
    }
    public int helper(int[][] arr, int m, int n, int ind){
        if((m<=0 && n<=0)||ind>=arr.length){
            return 0;
        }
        if(dp[ind][m][n] != -1){
            return dp[ind][m][n];
        }
        if(m<arr[ind][0] || n<arr[ind][1]){
            return dp[ind][m][n] = helper(arr, m, n, ind+1);
        }
        int include = 1+helper(arr, m-arr[ind][0], n-arr[ind][1], ind+1);
        int exclude = helper(arr, m, n, ind+1);
        dp[ind][m][n]=Math.max(include, exclude);
        return dp[ind][m][n];
    }
}