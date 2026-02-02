class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int res=nums[0];
        while(l<=r){
            int mid=(l+r)/2;
            System.out.println(mid);
            res = Math.min(res, Math.min(nums[l], nums[r]));
            res = Math.min(res, nums[mid]);
            if(nums[l]==nums[mid] && nums[r]==nums[mid]){
                l++;
                r--;
                continue;
            }
            if(mid-1>=0 && mid+1<n && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                res=Math.min(res,nums[mid]);
                break;
            }
            if(nums[l]<=nums[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return Math.min(nums[0], nums[n-1])<res ? Math.min(nums[0], nums[n-1]):res;
    }
}