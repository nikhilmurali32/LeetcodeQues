class Solution {
    public int minSwaps(int[] nums) {
        int ones=0;
        for(int num:nums){
            if(num==1){
                ones++;
            }
        }
        int n=nums.length;
        int curr_ones=0;
        int max_ones=0;
        int i=0;
        int j=0;
        while(j<n*2 && ones>0){
            if(nums[j%n]==1){
                curr_ones++;
            }
            if(j-i<ones-1){
                j++;
            }
            else if(j-i==ones-1){
                max_ones=Math.max(max_ones, curr_ones);
                if(nums[i%n]==1){
                    curr_ones--;
                }
                i++;
                j++;
            }
        }
        return ones-max_ones;
    }
}