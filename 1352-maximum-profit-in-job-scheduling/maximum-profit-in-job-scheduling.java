class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] mat = new int[n][3];
        for(int i=0; i<n; i++){
            mat[i][0]=startTime[i];
            mat[i][1]=endTime[i];
            mat[i][2]=profit[i];
        }
        Arrays.sort(mat, (a,b) -> a[1]-b[1]);
        int[] dp = new int[n];
        dp[0]=mat[0][2];
        for(int i=1; i<n; i++){
            int include=mat[i][2];
            int last = binarySearch(mat, i);
            if(last!=-1){
                include += dp[last];
            }
            dp[i] = Math.max(dp[i-1], include);
        }
        return dp[n-1];
    }
    public int binarySearch(int[][] mat, int ind){
        int i=0;
        int j=ind-1;
        int ans=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(mat[mid][1]<=mat[ind][0]){
                ans=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
}