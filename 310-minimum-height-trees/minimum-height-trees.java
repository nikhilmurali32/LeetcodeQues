class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> l = new ArrayList<>();
            l.add(0);
            return l;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        int[][] inDegrees = new int[n][2];
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<adjList.size(); i++){
            if(adjList.get(i).size()==1){
                leaves.add(i);
            }
        }
        int rem=n;
        while(rem>2){
            rem -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i=0; i<leaves.size(); i++){
                int nei = adjList.get(leaves.get(i)).get(0);
                adjList.get(nei).remove(leaves.get(i));
                if(adjList.get(nei).size()==1){
                    newLeaves.add(nei);
                }
            }
            leaves=newLeaves;
        }
        return leaves;        
    }
}