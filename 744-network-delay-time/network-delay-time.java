class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time:times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k, 0});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node=curr[0];
            int time=curr[1];
            if(time>dist[node]){
                continue;
            }
            for(int[] nei:adjList.get(node)){
                if(time+nei[1]<dist[nei[0]]){
                    dist[nei[0]] = time+nei[1];
                    pq.offer(new int[]{nei[0], nei[1]+time});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}