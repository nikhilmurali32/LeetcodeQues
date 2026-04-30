class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=edges.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0], v=edge[1];
            if(hasPath(u, v, adjList)){
                return new int[]{u,v};
            }
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return new int[]{-1,-1};
    }
    public boolean hasPath(int u, int v, List<List<Integer>> adjList){
        Queue<int[]> nodesQ = new LinkedList<>();
        nodesQ.add(new int[]{u,-1});
        while(!nodesQ.isEmpty()){
            int size = nodesQ.size();
            for(int i=0; i<size; i++){
                int currNode = nodesQ.peek()[0];
                int currNodeP = nodesQ.remove()[1];
                for(int nei:adjList.get(currNode)){
                    if(nei == v){
                        return true;
                    }
                    if(nei==currNodeP){
                        continue;
                    }
                    nodesQ.add(new int[]{nei, currNode});
                }
            }
        }
        return false;
    }
}