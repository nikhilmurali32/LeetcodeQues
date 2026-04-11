class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]==0?a[0]-b[0]:a[1]-b[1]));
        int n = intervals.length;
        // int[][] dp = new int[n+1][n+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        int count=0;
        int prevEndTime = intervals[0][1];
        for(int i=1; i<n; i++){
            if(intervals[i][0]<prevEndTime){
                count++;
            }
            else{
                prevEndTime=intervals[i][1];
            }
        }
        return count;
        // return countMinElemtoRemove(intervals, 0, -1, dp);
    }
    // public int countMinElemtoRemove(int[][] intervals, int currIndex, int prevIndex, int[][] dp){
    //     if(currIndex >= intervals.length){
    //         return dp[currIndex][prevIndex+1] = 0;
    //     }
    //     if(dp[currIndex][prevIndex+1] != -1){
    //         return dp[currIndex][prevIndex+1];
    //     }
    //     int doNotTake = 1+countMinElemtoRemove(intervals, currIndex+1, prevIndex, dp);
    //     int take = 100000;
    //     if(prevIndex == -1 || intervals[currIndex][0] >= intervals[prevIndex][1]){
    //         take = countMinElemtoRemove(intervals, currIndex+1, currIndex, dp);
    //     }        
    //     return dp[currIndex][prevIndex+1] = Math.min(take, doNotTake);
    // }
}