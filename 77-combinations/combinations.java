class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // boolean[] vis = new boolean[n];
        helper(n, k, 1, new ArrayList<>());
        return list;
    }
    public void helper(int n, int k, int ind, List<Integer> op){
        if(op.size()==k){
            // if(!list.contains(op)){
            list.add(new ArrayList<>(op));
            // }
            return;
        }
        for(int i=ind; i<=n; i++){
            // if(vis[i-1]){
            //     continue;
            // }
            op.add(i);
            helper(n, k, i+1, op);
            op.remove(op.size()-1);
            // helper(n, k, ind+1, op, vis);
        }
    }
}