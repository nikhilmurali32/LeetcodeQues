class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int n=costs.length/2;
        int totalCost=0;
        for(int[] cost:costs){
            pq.add(new int[]{cost[1]-cost[0], cost[0]});
            if(pq.size()>n){
                totalCost += (pq.peek()[0]+pq.peek()[1]);
                pq.remove();
            }
        }
        while(!pq.isEmpty()){
            totalCost += pq.peek()[1];
            pq.remove();
        }
        return totalCost;
    }
}