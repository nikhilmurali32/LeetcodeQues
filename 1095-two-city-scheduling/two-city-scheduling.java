class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]-a[0]))-(b[1]-b[0]));
        int len=costs.length/2;
        int cityBtotal=0;
        for(int[] cost:costs){
            pq.offer(cost);
            while(pq.size()>len){
                pq.poll();
            }
            cityBtotal += cost[1];
        }
        System.out.println(pq.peek()[0]);
        int totalCost=0;
        int notCityB=0;
        while(!pq.isEmpty()){
            System.out.println(pq.peek()[0]);
            totalCost += pq.peek()[0];
            notCityB += pq.poll()[1];
        }
        return totalCost + cityBtotal-notCityB;


    }
}