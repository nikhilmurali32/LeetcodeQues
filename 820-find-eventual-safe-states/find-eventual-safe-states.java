class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            revGraph.add(new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                revGraph.get(graph[i][j]).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] outDegrees = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            outDegrees[i] = graph[i].length;
            if(outDegrees[i]==0){
                q.add(i);
            }
        }
        boolean[] safe = new boolean[graph.length];
        while(!q.isEmpty()){
            int ele = q.poll();
            safe[ele]=true;
            for(int prev:revGraph.get(ele)){
                outDegrees[prev]--;
                if(outDegrees[prev]==0){
                    q.add(prev);
                }
            }
        }

        for(int i=0; i<graph.length; i++){
            if(safe[i]){
                list.add(i);
            }
        }
        return list;
    }
}