class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        boolean[] dp = new boolean[n];
        if(nums[0]==0){
            if(n==1){
                return true;
            }
            return false;
        }
        dp[0]=true;
        for(int i=0; i<n-1; i++){
            int j=i;
            while(dp[i] && j<=i+nums[i] && j<n){
                dp[j]=true;
                j++;
            }
            if(dp[n-1]){
                return true;
            }
            if(!dp[i]){
                return false;
            }
        }
        return false;
    }
}