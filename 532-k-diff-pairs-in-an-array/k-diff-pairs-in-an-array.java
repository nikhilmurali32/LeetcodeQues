class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> hset = new HashSet<>();
        int count=0;
        int prev_same=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                if(k==0 && nums[i]!=prev_same){
                    count++;
                }
                prev_same=nums[i];
                continue;
            }
            if(hset.contains(nums[i]-k)){
                count++;
            }
            // if(hset.contains(nums[i]+k)){
            //     count++;
            // }
            hset.add(nums[i]);
        }
        return count;
    }
}