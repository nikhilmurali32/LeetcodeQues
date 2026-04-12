class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return validString(s, 0, 0, dp);
    }
    public boolean validString(String s, int openCount, int index, Boolean[][] dp){
        if(openCount<0){
            return false;
        }
        if(index==s.length()){
            return openCount==0;
        }
        if(dp[index][openCount] != null){
            return dp[index][openCount];
        }
        if(s.charAt(index)=='('){
            return dp[index][openCount] = validString(s, openCount+1, index+1, dp);
        }
        else if(s.charAt(index)==')'){
            return dp[index][openCount] = validString(s, openCount-1, index+1, dp);
        }
        return dp[index][openCount] = (validString(s, openCount+1, index+1, dp) || validString(s, openCount, index+1, dp) ||validString(s, openCount-1, index+1, dp));
    }
}