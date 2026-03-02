class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] res = new int[2];
        Arrays.fill(res,-1);
        if(n==0){
            return res;
        }
        int l=0, r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        if(nums[l]!=target){
            return res;
        }
        res[0]=l;
        r=n-1;
        while(l<r){
            int mid=((l+r)/2)+1;
            if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid;
            }
        }
        res[1]=r;
        return res;
    }
}