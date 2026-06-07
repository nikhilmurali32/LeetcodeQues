class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l>nums.length-1 || nums[l]!=target?-1:l;
    }
}