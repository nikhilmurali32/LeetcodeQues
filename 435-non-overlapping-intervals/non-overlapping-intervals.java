class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int currEnd = intervals[0][1];
        int count = 0;
        int i = 1;
        while(i<n){
            if(intervals[i][0] < currEnd){
                count++;
                currEnd = Math.min(currEnd, intervals[i][1]);
            }
            else{
                currEnd = intervals[i][1];
            }
            i++;
        }
        return count;
    }
}