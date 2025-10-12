class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,0});
        boolean[] vis = new boolean[n];
        int minCost=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost=curr[0];
            int point=curr[1];
            if(vis[point]){
                continue;
            }
            vis[point]=true;
            minCost += cost;
            for(int i=0; i<n; i++){
                if(!vis[i]){
                    int dist = Math.abs(points[point][0]-points[i][0]) + Math.abs(points[point][1]-points[i][1]);
                    if(dist<hmap.getOrDefault(i, Integer.MAX_VALUE)){
                        pq.offer(new int[]{dist,i});
                        hmap.put(i, dist);
                    }
                }
            }
        }
        return minCost;
    }
}