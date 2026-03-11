class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int n=0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n=nums.length;
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[n]);
        return list;
    }
    public void helper(int[] nums, List<Integer> op, boolean[] b){
        if(op.size()==n){
            if(!list.contains(new ArrayList<>(op))){
                list.add(new ArrayList<>(op));
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(b[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && b[i-1]){
                continue;
            }
            op.add(nums[i]);
            b[i]=true;
            helper(nums, op, b);
            op.remove(op.size()-1);
            b[i]=false;
        }
    }
}