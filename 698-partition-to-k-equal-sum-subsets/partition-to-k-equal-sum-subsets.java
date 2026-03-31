class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        if(sum%k != 0){
            return false;
        }
        int target = sum/k;
        Arrays.sort(nums);
        if(nums[0]>target){
            return false;
        }
        boolean[] vis = new boolean[nums.length];
        return find(nums, target, k, 0, nums.length-1, vis);
    }
    public boolean find(int[] nums, int target, int k, int currentSum, int ind, boolean[] vis){
        if(k==1){
            return true;
        }
        if(currentSum==target){
            return find(nums, target, k-1, 0, nums.length-1, vis);
        }
        for(int i=ind; i>=0; i--){
            if(vis[i] || currentSum+nums[i]>target){
                continue;
            }
            vis[i]=true;
            if(find(nums, target, k, currentSum+nums[i], i-1, vis)){
                return true;
            }
            vis[i]=false;
        }
        return false;
    }
}