class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[] dp = new int[n];
        int[] dp_copy = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    dp_copy[j]=matrix[i][j];
                }
                else{
                    if(j==0){
                        dp_copy[j] = matrix[i][j]+Math.min(dp[j], dp[j+1]);
                    }
                    else if(j==n-1){
                        dp_copy[j] = matrix[i][j]+Math.min(dp[j], dp[j-1]);
                    }
                    else{
                        dp_copy[j] = matrix[i][j]+Math.min(dp[j+1], Math.min(dp[j], dp[j-1]));
                    }
                }
            }
            dp = Arrays.copyOf(dp_copy, n);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}