class Solution {
    public int countPaths(int n, int[][] roads) {
        if(roads.length==0){
            return 1;
        }
        Map<Integer, List<int[]>> graph = new HashMap<>();
        final int MOD = 1_000_000_007;
        for(int[] road:roads){
            graph.putIfAbsent(road[0], new ArrayList<>());
            graph.putIfAbsent(road[1], new ArrayList<>());
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        long[] dis = new long[n+1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        int[] ways = new int[n];
        ways[0] = 1;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int currNode = (int)curr[0];
            long dist = curr[1];
            for(int[] edge:graph.get(currNode)){
                if (dist + edge[1] < dis[edge[0]]) {
                    dis[edge[0]] = dist + edge[1];
                    pq.offer(new long[]{edge[0], dis[edge[0]]});
                    ways[edge[0]] = ways[currNode];
                } 
                else if (dist + edge[1] == dis[edge[0]]) {
                    ways[edge[0]] = (int)(ways[edge[0]] + (long) ways[currNode]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}