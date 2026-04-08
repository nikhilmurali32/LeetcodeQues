class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adjList.get(edge[0]).add(new int[]{edge[1], Integer.MAX_VALUE});
            adjList.get(edge[1]).add(new int[]{edge[0], Integer.MAX_VALUE});
        }
        Queue<int[]> minTimeQ = new LinkedList<>();
        minTimeQ.add(new int[]{1, 0, -1});
        boolean vis=false;
        int lastTime=Integer.MAX_VALUE;
        int[][] dist = new int[n+1][2];
        for(int[] arr:dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[1][0]=0;
        while(!minTimeQ.isEmpty()){
            int[] currNode = minTimeQ.remove();
            int node = currNode[0], nodeTime = currNode[1], parent = currNode[2];
            if(nodeTime>=change){
                if((nodeTime/change)%2==1){
                    nodeTime = (change*((nodeTime/change)+1));
                }
            }
            for(int[] nei:adjList.get(node)){
                if(nodeTime+time < dist[nei[0]][0]){
                    int secondMinTime = dist[nei[0]][0];
                    dist[nei[0]][0]=nodeTime+time;
                    dist[nei[0]][1]=secondMinTime;
                    minTimeQ.add(new int[]{nei[0], nodeTime+time, node});
                }
                else if(nodeTime+time > dist[nei[0]][0] && nodeTime+time < dist[nei[0]][1]){
                    dist[nei[0]][1]=nodeTime+time;
                    minTimeQ.add(new int[]{nei[0], nodeTime+time, node});                    
                }
            }
        }
        return dist[n][1];
    }
}