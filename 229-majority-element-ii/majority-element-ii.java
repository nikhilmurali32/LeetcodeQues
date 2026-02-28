class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int res1=0, res2=1, count1=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==res1){
                count1++;
            }
            else if(nums[i]==res2){
                count2++;
            }
            else if(count1==0){
                res1=nums[i];
                count1=1;
            }
            else if(count2==0){
                res2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==res1){
                count1++;
            }
            else if(num==res2){
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(count1>nums.length/3){
            list.add(res1);
        }
        if(count2>nums.length/3){
            list.add(res2);
        }
        return list;
    }
}