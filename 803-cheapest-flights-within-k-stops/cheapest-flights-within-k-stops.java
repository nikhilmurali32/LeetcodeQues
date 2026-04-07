class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int from=curr[0];
            int cost=curr[1];
            int stops = curr[2];
            for(int[] nei:adjList.get(from)){
                if(cost+nei[1] < dist[nei[0]] && stops<=k){
                    dist[nei[0]]=cost+nei[1];
                    q.add(new int[]{nei[0], cost+nei[1], stops+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}