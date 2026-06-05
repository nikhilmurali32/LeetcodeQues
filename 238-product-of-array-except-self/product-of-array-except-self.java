class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix,1);
        int count=1;
        for(int i=0; i<n; i++){
            prefix[i] *= count;
            count *= nums[i];
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        count=1;
        for(int i=n-1; i>=0; i--){
            ans[i] = prefix[i]*count;
            count *= nums[i];
        }
        return ans;
    }
}