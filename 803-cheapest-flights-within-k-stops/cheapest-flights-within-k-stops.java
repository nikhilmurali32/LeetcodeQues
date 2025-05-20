class Solution {
    class Tuple{
        int first;
        int second;
        int third;

        Tuple(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj_list = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            adj_list.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] dist = new int[n];
        for(int i=0; i<dist.length; i++){
            dist[i]=Integer.MAX_VALUE-1;
        }
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple ele=q.peek();
            q.remove();
            int stops=ele.first;
            int node=ele.second;
            int cost=ele.third;
            if(stops>k){
                continue;
            }
            for(Pair p: adj_list.get(node)){
                int adj_node=p.first;
                int edW=p.second;
                if(cost+edW < dist[adj_node] && stops<=k){
                    dist[adj_node]=cost+edW;
                    q.add(new Tuple(stops+1, adj_node, cost+edW));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE-1){
            return -1;
        }
        return dist[dst];
    }
}