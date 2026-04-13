class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0]=0;
        return countMinJumps(nums, 0, nums.length, dp);
    }
    public int countMinJumps(int[] nums, int index, int n, int[] dp){
        if(index>n-1){
            return 100000;
        }
        if(index==n-1){
            return 0;
        }
        int minJumps = 100000;
        for(int i=1; i<=nums[index]; i++){
            if(index+i > n-1){
                break;
            }
            if(dp[index+i] != Integer.MAX_VALUE){
                minJumps = Math.min(minJumps, 1+dp[index+i]);
            }
            else{
                minJumps = Math.min(minJumps, 1+countMinJumps(nums, index+i, n, dp));
            }
        }
        return dp[index] = minJumps;
    }
}