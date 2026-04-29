class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? Integer.compare(a[0], b[0]): Integer.compare(b[1], a[1]));
        int prevEndMax = intervals[0][1];
        int n = intervals.length;
        int count=0;
        for(int i=1; i<n; i++){
            if(intervals[i][1] <= prevEndMax){
                count++;
                continue;
            }
            prevEndMax = Math.max(prevEndMax, intervals[i][1]);
        }
        return n-count;
    }
}