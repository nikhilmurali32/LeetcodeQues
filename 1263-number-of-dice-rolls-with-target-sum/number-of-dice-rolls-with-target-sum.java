class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n+1][target+1];
        int min=Math.min(target, k);
        for(int j=1; j<=target; j++){
            if(j<=k){
                dp[1][j]=1;
            }
            else{
                break;
            }
        }

        for(int i=2; i<=n; i++){
            for(int j=2; j<=target; j++){
                if(j<i){
                    continue;
                }
                if(j==i){
                    dp[i][j]=1;
                    continue;
                }
                int start = j-k;
                if(j<=k+1){
                    start=1;
                }
                int end=j-1;
                long sum=0;
                for(int l=start; l<=end; l++){
                    sum += dp[i-1][l];
                }
                dp[i][j] = sum%(long)(Math.pow(10,9)+7);

            }
        }
        return (int)(dp[n][target]%(long)(Math.pow(10,9)+7));
    }
}