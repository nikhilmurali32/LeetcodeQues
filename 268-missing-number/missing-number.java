class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        // for(int i=0; i<n; i++){
        //     while(nums[i]<n && nums[i]>=0 && nums[i]!=nums[nums[i]]){
        //         int temp=nums[nums[i]];
        //         nums[nums[i]]=nums[i];
        //         nums[i]=temp;
        //     }
        // }
        // for(int i=0; i<n; i++){
        //     if(nums[i]!=i){
        //         return i;
        //     }
        // }
        // return n;
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        int tot=(n*(n+1))/2;
        return tot-sum;
    }
}