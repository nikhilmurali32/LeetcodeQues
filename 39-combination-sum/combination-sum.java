class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, new ArrayList<>(), 0, target, res);
        return res;
    }
    public void findCombinations(int[] nums, List<Integer> list, int ind, int rem, List<List<Integer>> res){
        if(rem<0){
            return;
        }
        if(rem==0){
            res.add(new ArrayList<>(list));
        }
        for(int i=ind; i<nums.length; i++){
            if(nums[i]<=rem){
                list.add(nums[i]);
                findCombinations(nums, list, i, rem-nums[i], res);
                list.remove(list.size()-1);
            }
        }
    }
}