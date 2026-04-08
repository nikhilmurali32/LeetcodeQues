class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time:times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> leastTime = new PriorityQueue<>((a,b)->a[1]-b[1]);
        leastTime.add(new int[]{k, 0});
        int[] totalTime = new int[n+1];
        Arrays.fill(totalTime, Integer.MAX_VALUE);
        totalTime[k] = 0;
        int maxTime=0;
        while(!leastTime.isEmpty()){
            int[] currNode = leastTime.remove();
            int node = currNode[0];
            int time = currNode[1];
            if(time>totalTime[node]){
                continue;
            }
            for(int[] nei:adjList.get(node)){
                if(time + nei[1] < totalTime[nei[0]]){
                    totalTime[nei[0]] = time + nei[1];
                    leastTime.add(new int[]{nei[0], time + nei[1]});
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(totalTime[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, totalTime[i]);
        }
        return maxTime==0?-1:maxTime;
        
    }
}