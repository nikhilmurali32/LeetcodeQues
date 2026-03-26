class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        for(int i=0; i<trips.length; i++){
            while(!pq.isEmpty() && trips[i][1]>=pq.peek()[1]){
                capacity += pq.remove()[0];
            }
            if(capacity<trips[i][0]){
                return false;
            }
            capacity -= trips[i][0];
            pq.add(new int[]{trips[i][0], trips[i][2]});
        }
        return true;
    }
}