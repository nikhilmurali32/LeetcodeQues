class Solution {
    public int partitionDisjoint(int[] nums) {
        int local_max=nums[0];
        int n=nums.length;
        int max=local_max;
        int p_ind=0;
        for(int i=1; i<n; i++){
            if(nums[i]<local_max){
                p_ind=i;
                local_max=max;
            }
            else{
                max=Math.max(max, nums[i]);
            }
        }
        return p_ind+1;
    }
}