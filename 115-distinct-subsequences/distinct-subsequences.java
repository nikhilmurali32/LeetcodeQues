class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length(), n=t.length();
        if(m<n){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return countSubseq(s, t, 0, 0, m, n, dp);
    }
    public int countSubseq(String s, String t, int i, int j, int m, int n,int[][] dp){
        if(j==n){
            return dp[i][j]=1;
        }
        if(i==m){
            return dp[i][j]=0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int doNotTake = countSubseq(s, t, i+1, j, m, n, dp);
        int take = 0;
        if(s.charAt(i)==t.charAt(j)) {
            take = countSubseq(s, t, i+1, j+1, m, n, dp);
        }

        return dp[i][j] = doNotTake + take;
    }
}