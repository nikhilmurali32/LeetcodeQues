class Solution {
    public int majorityElement(int[] nums) {
        int maj=0;
        int res=nums[0];
        for(int num:nums){
            if(maj==0){
                res=num;
            }
            if(num==res){
                maj++;
            }
            else{
                maj--;
            }
        }
        return res;
    }
}