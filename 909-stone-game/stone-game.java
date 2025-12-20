class Solution {
    int[][][] dp;
    int max=0;
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        dp = new int[n+1][n+1][2];
        for(int[][] arr: dp){
            for(int[] subArr: arr){
                Arrays.fill(subArr, -1);
            }
        }
        return helper(piles, 1, 0, n-1)>=0;
    }
    public int helper(int[] piles, int id, int l, int r){
        if(r<l){
            return 0;
        }
        if(dp[l][r][id]!=-1){
            return dp[l][r][id];
        }
        if(id==1){
            dp[l][r][1] = Math.max(piles[l]+helper(piles, 0, l+1, r), piles[r]+helper(piles, 0, l, r-1));
        }
        if(id==0){
            dp[l][r][0] = Math.max(-piles[l]+helper(piles, 1, l+1, r), -piles[r]+helper(piles, 1, l, r-1));
        }
        return dp[l][r][id];
    }
}