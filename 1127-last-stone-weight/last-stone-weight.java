class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int stone:stones){
            pq.add(stone);
        }
        while(!pq.isEmpty()){
            int y=pq.poll();
            if(pq.isEmpty()){
                return y;
            }
            int x=pq.poll();
            if(y!=x){
                pq.offer(y-x);
            }
        }
        return 0;
    }
}