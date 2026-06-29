class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        helper(n, dp);
        return dp[n];
    }
    public int helper(int n, int[] dp){
        if(n==0 || n==1){
            return dp[n]=1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int totalCount=0;
        for(int i=1; i<n+1; i++){
            int countLeft = helper(i-1, dp);
            int countRight = helper(n-i, dp);
            totalCount += countLeft*countRight;
        }
        return dp[n]=totalCount;
    }
}