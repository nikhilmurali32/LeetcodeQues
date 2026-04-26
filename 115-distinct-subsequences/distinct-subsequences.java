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
        return countSubseq(s, t, 0, 0, m, n, new StringBuilder(), dp);
    }
    public int countSubseq(String s, String t, int i, int j, int m, int n, StringBuilder sb, int[][] dp){
        if(sb.length()>n){
            return dp[i][j]=0;
        }
        if(j==n || i==m){
            if(sb.toString().equals(t)) return dp[i][j]=1;
            else return dp[i][j]=0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int doNotTake = countSubseq(s, t, i+1, j, m, n, sb, dp);
        int take = 0;
        if(s.charAt(i)==t.charAt(j)) {
            sb.append(s.charAt(i));
            take = countSubseq(s, t, i+1, j+1, m, n, sb, dp);
            sb.deleteCharAt(sb.length()-1);
        }

        return dp[i][j] = doNotTake + take;
    }
}