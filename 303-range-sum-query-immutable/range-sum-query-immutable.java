class NumArray {
    // int[] _nums;
    // public NumArray(int[] nums) {
    //     // for(int i)
    //     this._nums=nums;
    // }
    
    // public int sumRange(int left, int right) {
    //     int sum_left=0;
    //     int sum_right=0;
    //     for(int i=0; i<_nums.length; i++){
    //         if(i<left){
    //             sum_left += _nums[i];
    //         }
    //         if(i<=right){
    //             sum_right += _nums[i];
    //             if(i==right){
    //                 break;
    //             }
    //         }
    //     }
    //     return sum_right-sum_left;
    // }
int[] nums;

public NumArray(int[] nums) {
    for(int i = 1; i < nums.length; i++)
        nums[i] += nums[i - 1];
    
    this.nums = nums;
}

public int sumRange(int i, int j) {
    if(i == 0)
        return nums[j];
    
    return nums[j] - nums[i - 1];
}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */