class Solution {
    public int findDuplicate(int[] nums) {
        // for(int i=0; i<nums.length-1; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j]==nums[i]){
        //             return nums[i];
        //         }
        //     }
        // }
        // return -1;
        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2=0;
        while(slow2!=slow){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        return slow;
    }
}