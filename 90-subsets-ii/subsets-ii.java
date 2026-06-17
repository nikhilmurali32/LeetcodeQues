class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, new ArrayList<>(), 0, res, new HashSet<>());
        return res;        
    }
    public void findSubsets(int[] nums, List<Integer> list, int ind, List<List<Integer>> res, HashSet<List<Integer>> hset){
        if(ind==nums.length){
            if(!hset.contains(list)){
                hset.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }
        findSubsets(nums, list, ind+1, res, hset);
        list.add(nums[ind]);
        findSubsets(nums, list, ind+1, res, hset);
        list.remove(list.size()-1);
    }
}