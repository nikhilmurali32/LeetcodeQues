class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
                continue;
            }
            i++;
        }
        i=0;
        while(i<nums.length){
            if(i+1 != nums[i]){
                return i+1;
            }
            i++;
        }
        return i+1;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}