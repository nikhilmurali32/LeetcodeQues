class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> indicesMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(indicesMap.containsKey(nums[i])){
                if(nums[i]+nums[i]==target){
                    res[0]=i;
                    res[1]=indicesMap.get(nums[i]);
                    return res;
                }
                else{
                    continue;
                }
            }
            indicesMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        int l=0, r=nums.length-1;
        while(l<r){
            if(l>0 && nums[l]==nums[l-1]){
                l++;
                continue;
            }
            if(r<nums.length-1 && nums[r]==nums[r+1]){
                r--;
                continue;
            }
            int sum = nums[l]+nums[r];
            if(sum==target){
                res[0]=indicesMap.get(nums[l]);
                res[1]=indicesMap.get(nums[r]);
                break;
            }
            else if(sum<target){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}