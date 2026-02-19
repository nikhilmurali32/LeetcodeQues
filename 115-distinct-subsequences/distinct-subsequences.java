class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return helper(s, t, 0, 0, "");
    }
    public int helper(String s, String t, int i, int j, String str){
        if(i>s.length()-1 || j>t.length()-1 || str.equals(t)){
            if(str.equals(t)){
                return 1;
            }
            return 0;
        }
        // str += s.charAt(i);
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = helper(s, t, i+1, j+1, str+s.charAt(i)) + helper(s, t, i+1, j, str);
        }
        return dp[i][j] = helper(s, t, i+1, j, str);
    }
}