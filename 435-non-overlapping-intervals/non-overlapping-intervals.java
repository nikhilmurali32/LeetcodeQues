class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        int prevEndTime = intervals[0][1], count=0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<prevEndTime){
                count++;
                prevEndTime = Math.min(prevEndTime, intervals[i][1]);
                continue;
            }
            prevEndTime = Math.max(prevEndTime, intervals[i][1]);
        }
        return count;
    }
}