class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.offer(new int[]{src, 0, 0});
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int from=curr[0];
            int cost=curr[1];
            int stops = curr[2];
            if(from==dst){
                return cost;
            }
            if(minStops[from]<stops){
                continue;
            }
            minStops[from]=stops;
            for(int[] nei:adjList.get(from)){
                if(stops<=k){
                    // dist[nei[0]]=cost+nei[1];
                    pq.add(new int[]{nei[0], cost+nei[1], stops+1});
                }
            }
        }
        return -1;
    }
}