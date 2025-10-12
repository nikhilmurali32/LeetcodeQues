class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n=graph.length-1;
        List<Integer> op = new ArrayList<>();
        op.add(0);
        helper(graph,0,op);
        return list;
    }
    public void helper(int[][] graph, int ind, List<Integer> op){
        if(ind==n){
            list.add(new ArrayList<>(op));
            return;
        }
        for(int i:graph[ind]){
            op.add(i);
            helper(graph, i, op);
            op.remove(op.size()-1);
        }
    }
}