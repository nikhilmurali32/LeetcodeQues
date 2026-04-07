class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] road:roads){
            adjList.get(road[0]).add(new long[]{road[1], road[2]});
            adjList.get(road[1]).add(new long[]{road[0], road[2]});
        }
        long[] minTimetoReach = new long[n];
        Arrays.fill(minTimetoReach, Long.MAX_VALUE);
        PriorityQueue<long[]> leastTime = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        leastTime.add(new long[]{0, 0});
        long minLastNodeTime=Long.MAX_VALUE;
        long[] ways = new long[n];
        ways[0]=1;
        long MOD = 7+1000000000;
        while(!leastTime.isEmpty()){
            long[] currNode = leastTime.remove();
            int node = (int)currNode[0];
            long time = currNode[1];
            if(minTimetoReach[node]<time){
                continue;
            }
            for(long[] nei:adjList.get(node)){
                if(time+nei[1] < minTimetoReach[(int)nei[0]]){
                    minTimetoReach[(int)nei[0]] = time+nei[1];
                    leastTime.add(new long[]{nei[0], time+nei[1]});
                    ways[(int)nei[0]]=ways[node];
                }
                else if(time+nei[1] == minTimetoReach[(int)nei[0]]){
                    ways[(int)nei[0]] = (ways[(int)nei[0]] + ways[node])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}