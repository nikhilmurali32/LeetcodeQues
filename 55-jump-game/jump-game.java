class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        boolean[] dp = new boolean[n];
        int max_ind=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0 && i>=max_ind && i!=n-1){
                return false;
            }
            max_ind=Math.max(max_ind, i+nums[i]);
        }
        return max_ind>=n-1;
    }
}