class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color = new int[n];
        for(int i=0; i<n; i++){
            color[i]=-1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<graph[i].length; j++){
                if(color[graph[i][j]]==-1 && !helper(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int ind, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(ind);
        color[ind]=0;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int i:graph[node]){
                if(color[i]==-1){
                    color[i] = 1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}