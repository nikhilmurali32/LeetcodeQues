class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> hmap = new HashMap<>();
        for(int[] edge:times){
            hmap.putIfAbsent(edge[0], new ArrayList<>());
            hmap.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        dis[k]=0;
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.offer(new int[]{0,k});
        int max=0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int dist=node[0];
            int elem=node[1];
            if(vis[elem]){
                continue;
            }
            vis[elem]=true;
            max=dist;
            n--;
            if(!hmap.containsKey(elem)){
                continue;
            }
            for(int[] next:hmap.get(elem)){
                if(!vis[next[0]] && dist+next[1]<dis[next[0]]){
                    pq.offer(new int[]{dist+next[1], next[0]});
                }
            }
            
        }
        return n==0?max:-1;
    }
}