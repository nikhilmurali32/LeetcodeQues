class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        Set<String> hset = new HashSet<>(wordDict);
        return helper(s, hset, 0);
    }
    public boolean helper(String s, Set<String> hset, int ind){
        if(ind==s.length()){
            return true;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        for(int i=ind+1; i<=s.length(); i++){
            String str = s.substring(ind, i);
            if(hset.contains(str) && helper(s, hset, i)){
                return dp[ind]=true;
            }
        }
        return dp[ind]=false;
    }
}