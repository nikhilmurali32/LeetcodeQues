class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int low=0;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        int rot=l;
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            int real_mid = (mid+rot)%nums.length;
            if(nums[real_mid]==target){
                return real_mid;
            }
            else if(nums[real_mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}