class Solution {
    public void sortColors(int[] nums) {
        int l=0, r=nums.length-1, i=0;
        while(i<nums.length && i<=r){
            if(nums[i]==0){
                swap(i,l,nums);
                l++;
                i++;
            }
            else if(nums[i]==2){
                swap(i,r,nums);
                r--;
            }
            else{
                i++;
            }
        }
    }
    public void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}