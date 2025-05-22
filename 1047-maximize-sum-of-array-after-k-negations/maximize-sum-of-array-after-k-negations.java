class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; k>0 && i<n && nums[i]<0; i++, k--){
            nums[i]=nums[i]*-1;
        }
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int num: nums){
            sum += num;
            min=Math.min(min,num);
        }
        return sum-(k%2)*min*2;
    }
}