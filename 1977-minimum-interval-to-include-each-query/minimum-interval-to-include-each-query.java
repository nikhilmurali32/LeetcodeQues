class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m=intervals.length, n=queries.length;
        PriorityQueue<int[]> leastValid = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        int[][] queriesIndex = new int[n][2];
        for(int i=0; i<n; i++){
            queriesIndex[i][0] = queries[i];
            queriesIndex[i][1] = i;
        }
        Arrays.sort(queriesIndex, (a,b) -> (a[0]-b[0]));
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        int prevIndex=0;
        for(int i=0; i<n; i++){
            int query = queriesIndex[i][0], index = queriesIndex[i][1];
            for(int j=prevIndex; j<m; j++){
                if(intervals[j][0]<=query){
                    leastValid.add(new int[]{intervals[j][0], intervals[j][1], intervals[j][1]-intervals[j][0]+1});
                }
                else{
                    prevIndex=j;
                    break;
                }
            }
            while(!leastValid.isEmpty() && leastValid.peek()[1] < query){
                leastValid.remove();
            }
            queries[index]=leastValid.isEmpty()?-1:leastValid.peek()[2];
        }
        return queries;
    }
}