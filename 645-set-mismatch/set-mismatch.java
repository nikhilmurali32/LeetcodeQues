class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        // Arrays.sort(nums);
        HashSet<Integer> hset = new HashSet<>();
        int[] res= new int[2];
        int sum=0;
        for(int i=0; i<n; i++){
            if(!hset.add(nums[i])){
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