class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        return helper(s, p, 0, 0, dp);
    }
    public boolean helper(String s, String p, int i, int j, boolean[][] dp){
        int n1=s.length();
        int n2=p.length();
        // if(i>n1 || j>n2){

        // }
        if(i<n1 && j<n2 && dp[i][j]==true){
            return true;
        }
        if(i>=n1 && j>=n2){
            return dp[i][j]=true;
        }
        if(j>=n2){
            return dp[i][j]=false;
        }
        boolean match = i<n1 && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if((j+1)<n2 && p.charAt(j+1)=='*'){
            return dp[i][j]=helper(s,p,i,j+2, dp) || (match && helper(s,p,i+1, j, dp));
        }
        if(match){
            return dp[i][j]=helper(s,p,i+1,j+1, dp);
        }
        return dp[i][j]=false;
    }
}