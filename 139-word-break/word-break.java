class Solution {
    boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()+1];
        dp[0]=true;
        Set<String> hset = new HashSet<>(wordDict);
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && hset.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    // public boolean helper(String s, Set<String> hset, int ind){
    //     if(ind==s.length()){
    //         return true;
    //     }
    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }
    //     for(int i=ind+1; i<=s.length(); i++){
    //         String str = s.substring(ind, i);
    //         if(hset.contains(str) && helper(s, hset, i)){
    //             return dp[ind]=true;
    //         }
    //     }
    //     return dp[ind]=false;
    // }
}