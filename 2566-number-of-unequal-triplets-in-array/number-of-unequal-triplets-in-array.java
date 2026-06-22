class Solution {
    // [1,1,2,2,3,3,4,4]
    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        if(freq.size()<3){
            return 0;
        }
        int left=0, right=nums.length;
        int ans=0;
        for(int count:freq.values()){
            right -= count;
            ans += (left*count*right);
            left += count;
        }
        return ans;
    }
}