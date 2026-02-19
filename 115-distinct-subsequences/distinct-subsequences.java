class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        // return helper(s, t, 0, 0, "");
        dp[0][0]=1;
        for(int i=0; i<s.length()+1; i++){
            dp[i][0]=1;
        }
        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<t.length()+1; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];


    }
    // public int helper(String s, String t, int i, int j, String str){
    //     if(i>s.length()-1 || j>t.length()-1 || str.equals(t)){
    //         if(str.equals(t)){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(dp[i][j] != null){
    //         return dp[i][j];
    //     }
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j] = helper(s, t, i+1, j+1, str+s.charAt(i)) + helper(s, t, i+1, j, str);
    //     }
    //     return dp[i][j] = helper(s, t, i+1, j, str);
    // }
}