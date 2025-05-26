class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        // for(int i)
        this.nums=nums;
    }
    
    public int sumRange(int left, int right) {
        int sum_left=0;
        int sum_right=0;
        for(int i=0; i<nums.length; i++){
            if(i<left){
                sum_left += nums[i];
            }
            if(i<=right){
                sum_right += nums[i];
                if(i==right){
                    break;
                }
            }
        }
        return sum_right-sum_left;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */