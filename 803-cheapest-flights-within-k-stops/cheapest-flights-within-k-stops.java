class Solution {
    class Node{
        int city;
        int dist;
        int stops;
        Node(int city, int dist, int stops){
            this.city=city;
            this.dist=dist;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adjList.get(flight[0]).add(new Node(flight[1], flight[2], 0));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Node(src, 0, 0));
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            Node node = pq.remove();
            if(node.city==dst){
                return node.dist;
            }
            if(node.stops>k || minStops[node.city]<=node.stops){
                continue;
            }
            minStops[node.city] = node.stops;
            for(Node nei:adjList.get(node.city)){
                pq.add(new Node(nei.city, node.dist+nei.dist, node.stops+1));
            }
        }
        return -1;
    }
}