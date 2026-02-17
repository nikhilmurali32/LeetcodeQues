class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return helper(days, costs, 0);
    }
    public int helper(int[] days, int[] costs, int ind){
        int n=days.length;
        if(ind>n-1){
            return 0;
        }
        if(dp[ind] != Integer.MAX_VALUE){
            return dp[ind];
        }
        int oneDay = costs[0]+helper(days, costs, ind+1);
        int i=ind;
        while(i<n && days[i]<days[ind]+7){
            i++;
        }
        int sevenDay = costs[1]+helper(days, costs, i);
        i=ind;
        while(i<n && days[i]<days[ind]+30){
            i++;
        }
        int thirtyDay = costs[2]+helper(days, costs, i);

        return dp[ind]=Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}