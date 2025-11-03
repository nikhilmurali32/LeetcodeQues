class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int i=0;
        int r=nums.length-1;
        while(i<nums.length && i<=r){
            if(nums[i]==0){
                swap(i, l, nums);
                // i++;
                l++;
                i++;
            }
            else if(nums[i]==1){
                i++;
            }
            else{
                swap(i, r, nums);
                r--;
                // i++;
            }
        }
    }
    public void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}