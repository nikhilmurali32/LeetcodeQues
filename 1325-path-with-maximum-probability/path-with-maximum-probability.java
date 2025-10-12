class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        // int n=edges.length;
        for(int i=0; i<edges.length; i++){
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        if(!graph.containsKey(start_node)){
            return 0;
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1],a[1]));
        pq.offer(new double[]{start_node, 1});
        boolean[] vis = new boolean[n+1];
        double[] prob = new double[n+1];
        prob[start_node]=1;
        double max=0;
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            int node=(int)curr[0];
            double currProb=curr[1];
            if(vis[node]){
                continue;
            }
            vis[node]=true;
            for(double[] nei:graph.get(node)){
                if(!vis[(int)nei[0]] && nei[1]*currProb>prob[(int)nei[0]]){
                    pq.offer(new double[]{nei[0], nei[1]*currProb});
                    prob[(int)nei[0]]=nei[1]*currProb;
                }
            }
        }
        return prob[end_node];
    }
}