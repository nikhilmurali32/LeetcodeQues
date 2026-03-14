class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int[] min_left = new int[n];
        Arrays.fill(min_left, Integer.MAX_VALUE);
        int min=nums[0];
        for(int i=1; i<n; i++){
            if(min<nums[i]){
                min_left[i]=min;
            }
            min=Math.min(min, nums[i]);
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=n-1; i>=0; i--){
            if(treeSet.lower(nums[i]) != null && treeSet.lower(nums[i]) > min_left[i]){
                return true;
            }
            treeSet.add(nums[i]);
        }
        return false;
    }
}