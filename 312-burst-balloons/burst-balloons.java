class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] temp_nums = new int[n+2];
        for(int i=0; i<n+2; i++){
            if(i==0 || i==n+1){
                temp_nums[i]=1;
                continue;
            }
            temp_nums[i]=nums[i-1];
        }
        Integer[][] dp = new Integer[n+2][n+2];
        return helper(temp_nums, dp, 0, n+1);
    }
    public int helper(int[] nums, Integer[][] dp, int l, int r){
        if(l+1==r){
            return 0;
        }
        if(dp[l][r] != null){
            return dp[l][r];
        }
        int ans=-1;
        for(int i=l+1; i<r; i++){
            ans=Math.max(ans, nums[l]*nums[i]*nums[r] + helper(nums, dp, l, i) + helper(nums, dp, i, r));
        }
        return dp[l][r]=ans;
    }
}