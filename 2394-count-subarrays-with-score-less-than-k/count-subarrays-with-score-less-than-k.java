class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        int j=0;
        long sum=0;
        long count=0;
        while(j<nums.length && i<=j){
            sum += nums[j];
            if(sum*(j-i+1)<k){
                count += (j-i+1);
                j++;
            }
            else{
                sum -= nums[i];
                sum -= nums[j];
                if(i==j){
                    sum += nums[j];
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
        }
        return count;
    }
}