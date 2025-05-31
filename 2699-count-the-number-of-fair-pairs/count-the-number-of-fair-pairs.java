class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long ans=0;
        for(int i=0; i<n; i++){
            int minReq = lower-nums[i];
            int maxReq = upper-nums[i];
            int low = lower(nums, minReq, i+1, n);
            int high = higher(nums, maxReq, i+1, n);
            ans += (high-low);
        }
        return ans;
    }
    public int lower(int[] nums, int minReq, int l, int r){
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<minReq){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public int higher(int[] nums, int maxReq, int l, int r){
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<=maxReq){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}