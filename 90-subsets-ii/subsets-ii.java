class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, new ArrayList<>(), 0, res);
        return res;        
    }
    public void findSubsets(int[] nums, List<Integer> list, int ind, List<List<Integer>> res){
        if(ind==nums.length){
            if(!res.contains(list)){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        findSubsets(nums, list, ind+1, res);
        list.add(nums[ind]);
        findSubsets(nums, list, ind+1, res);
        list.remove(list.size()-1);
    }
}