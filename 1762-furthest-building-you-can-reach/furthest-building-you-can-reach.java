class Solution {
    // [-2,4,-1,2,1,-2]
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i=1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(; i<heights.length; i++){
            int diff = heights[i]-heights[i-1];
            if(diff<=0){
                continue;
            }
            else{
                pq.add(diff);
                if(pq.size()>ladders){
                    int minDiff = pq.remove();
                    if(bricks<minDiff){
                        break;
                    }
                    bricks -= minDiff;
                }
            }
        }
        return i-1;
    }
}