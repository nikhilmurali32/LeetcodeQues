class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(new double[]{(double)edges[i][1], succProb[i]});
            adjList.get(edges[i][1]).add(new double[]{(double)edges[i][0], succProb[i]});
        }
        PriorityQueue<double[]> maxProb = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        maxProb.add(new double[]{(double)start_node, 1});
        double[] maxProbArr = new double[n];
        Arrays.fill(maxProbArr, 0);
        maxProbArr[start_node]=1;
        while(!maxProb.isEmpty()){
            double[] currNode = maxProb.remove();
            int node = (int)currNode[0];
            double prob = currNode[1];
            if(prob < maxProbArr[node]){
                continue;
            }
            for(double[] nei:adjList.get(node)){
                if(prob*nei[1] > maxProbArr[(int)nei[0]]){
                    maxProbArr[(int)nei[0]] = prob*nei[1];
                    maxProb.add(new double[]{nei[0], prob*nei[1]});
                }
            }
        }
        return maxProbArr[end_node];
    }
}