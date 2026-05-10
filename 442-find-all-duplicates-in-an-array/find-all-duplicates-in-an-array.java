class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int maxVal = nums.length+1;
        List<Integer> res = new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     int currVal = nums[i]%maxVal;
        //     if(nums[currVal-1]/maxVal==currVal){
        //         res.add(currVal);
        //     }
        //     else{
        //         nums[currVal-1] += (currVal*maxVal);
        //     }
        // }
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1]<0){
                res.add(Math.abs(nums[i]));
            }
            else{
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        return res;
    }
}