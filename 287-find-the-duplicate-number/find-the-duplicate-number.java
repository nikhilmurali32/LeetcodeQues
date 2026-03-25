class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            if((i != nums[i]-1) && nums[i] == nums[nums[i]-1]){
                return nums[i];
            }
            while(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        return nums[n-1];
    }
}