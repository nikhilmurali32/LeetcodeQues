class Solution {
    public int[] shuffle(int[] nums, int n) {
        int maxVal = 1001;
        for(int i=0; i<n; i++){
            int x = nums[i]%maxVal;
            int y = nums[i+n]%maxVal;
            nums[2*i] += x*maxVal;
            nums[2*i+1] += y*maxVal;
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]/maxVal;
        }
        return nums;
    }
}