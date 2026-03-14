class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] res= new int[2];
        int sum=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i-1]==nums[i]){
                res[0]=nums[i];
            }
            sum+=nums[i];
        }
        int actual_sum=n*(n+1)/2;
        if(sum<actual_sum){
            res[1]=actual_sum-sum+res[0];
            return res;
        }
        res[1]=actual_sum+res[0]-sum;
        return  res;
    }
}