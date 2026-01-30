class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return list;
    }
    public void helper(int[] nums, List<Integer> op, int ind){
        if(ind==nums.length){
            if(!list.contains(op)){
                List<Integer> temp = new ArrayList<>(op);
                list.add(temp);
            }
            return;
        }
        // for(int i=ind; i<nums.length; i++){
        op.add(nums[ind]);
        helper(nums, op, ind+1);
        op.remove(op.size()-1);
        helper(nums, op, ind+1);
        // }
    }
}